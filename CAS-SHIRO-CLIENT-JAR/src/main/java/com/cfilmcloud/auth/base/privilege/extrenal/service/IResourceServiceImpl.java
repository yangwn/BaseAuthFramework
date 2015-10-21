package com.cfilmcloud.auth.base.privilege.extrenal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.privilege.mapper.ModuleMapper;
import com.base.privilege.mapper.ResourceMapper;
import com.base.privilege.mapper.UserMapper;
import com.base.privilege.model.Module;
import com.base.privilege.model.Resource;
import com.base.privilege.model.User;
import com.cfilmcloud.auth.base.commons.VariableUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

@Service
public class IResourceServiceImpl implements IResourceService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public Set<String> getPermissionsByUserName(String username) {
		Set<String> permissionSet = Sets.newHashSet();
		List<Resource> resourceList = resourceMapper.getResourceListByUserName(username);
		for (Resource resource : resourceList) {
			permissionSet.add(StringUtils.substringBetween(resource.getPermission(), "perms[", "]"));
		}
		return permissionSet;
	}

	@Override
	public List<Resource> getResourcesByUserName(String username) {
		List<Resource> resourceList = resourceMapper.getResourceListByUserName(username);
		return resourceList;
	}

	@Override
	public List<Map<String, Object>> getResourceTreeByUserName(Integer userId) {
		return this.getModuleTree(userId, null, null);
	}

	public List<Map<String, Object>> getModuleTree(Integer userId, String visitedModule, String visitedResource) {

		List<Map<String, Object>> resourceResList = Lists.newArrayList();
		visitedModule = StringUtils.isEmpty(visitedModule) ? "" : visitedModule;
		visitedResource = StringUtils.isEmpty(visitedResource) ? "" : visitedResource;

		User user = userMapper.selectByPrimaryKey(userId);
		if (user == null)
			return resourceResList;

		List<Module> moduleList = Lists.newArrayList();
		if (user.getIsAdmin()) {
			moduleList = moduleMapper.getModuleList();
		} else {
			moduleList = moduleMapper.getModuleListByUserId(userId);
		}
		if (moduleList == null || moduleList.size() == 0)
			return resourceResList;

		List<Resource> resourceList = Lists.newArrayList();
		if (user.getIsAdmin()) {
			resourceList = resourceMapper.getResourceList();
		} else {
			List<String> moduleFlags = new ArrayList<String>();
			for (Module m : moduleList) {
				moduleFlags.add(m.getFlag());
			}
			resourceList = resourceMapper.getResourceListByModuleFlag(moduleFlags, userId);
		}
		List<Map<String, Object>> resourceMapList = convertResourceToMap(resourceList);
		resourceResList = this.mergeResources(resourceMapList, null);
		return resourceResList;
	}

	/**
	 * 转换ResourceObject 为Map对象
	 * 
	 * @param resourceList
	 * @return
	 */
	private List<Map<String, Object>> convertResourceToMap(List<Resource> resourceList) {
		List<Map<String, Object>> resourceResultList = Lists.newArrayList();
		for (Resource resource : resourceList) {
			Map<String, Object> mapData = Maps.newHashMap();
			mapData.put("parentId", resource.getParentId());
			mapData.put("name", resource.getName());
			mapData.put("sortNo", resource.getSortNo());
			mapData.put("url", resource.getUrl());
			mapData.put("type", resource.getType());
			resourceResultList.add(mapData);
		}
		return resourceResultList;
	}

	/**
	 * 合并资源,获取资源的父类通过"parent"来获取,如果"parent" key为0, 表示该资源为根节点， 要获取资源的子类通过
	 * "children" 来获取
	 *
	 * @param resources
	 *            要合并的资源实体集合
	 * @param ignoreType
	 *            要忽略资源类型
	 *
	 * @return 合并好的树形资源实体集合
	 */
	private List<Map<String, Object>> mergeResources(List<Map<String, Object>> resources, Integer ignoreType) {

		List<Map<String, Object>> result = Lists.newArrayList();
		for (Map<String, Object> entity : resources) {
			Long parentId = VariableUtils.typeCast(entity.get("parentId"), Long.class);
			Integer type = VariableUtils.typeCast(entity.get("type"), Integer.class);
			// parentId为0, 则为根节点
			if (parentId == 0 && (ignoreType == null || !ignoreType.equals(type))) {
				recursionResource(entity, resources, ignoreType);
				result.add(entity);
			}
		}
		return result;
	}

	/**
	 * 递归并合并资源到指定的父类
	 *
	 * @param parent
	 *            父类
	 * @param resources
	 *            资源实体集合
	 * @param ignoreType
	 *            要忽略不合并的资源类型
	 */
	private void recursionResource(Map<String, Object> parent, List<Map<String, Object>> resources,
			Integer ignoreType) {

		parent.put("children", Lists.newArrayList());
		for (Map<String, Object> resource : resources) {
			Long parentId = VariableUtils.typeCast(resource.get("parentId"), Long.class);
			// 当为根节点时
			if (parentId == 0) {
				continue;
			}
			if ((ignoreType == null || !ignoreType.equals(resource.get("type")))
					&& parentId.equals(parent.get("parentId"))) {
				recursionResource(resource, resources, ignoreType);
				List<Map<String, Object>> children = VariableUtils.typeCast(parent.get("children"));
				if (children != null) {
					resource.put("parent", parent);
					children.add(resource);
				}
			}
		}
	}
}