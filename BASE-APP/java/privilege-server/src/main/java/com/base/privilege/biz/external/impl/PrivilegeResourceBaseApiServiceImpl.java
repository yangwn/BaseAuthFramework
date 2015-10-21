package com.base.privilege.biz.external.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.privilege.biz.external.IPrivilegeResourceBaseApiService;
import com.base.privilege.mapper.ModuleMapper;
import com.base.privilege.mapper.ResourceMapper;
import com.base.privilege.mapper.UserMapper;
import com.base.privilege.model.Module;
import com.base.privilege.model.Resource;
import com.base.privilege.model.User;
import com.google.common.collect.Lists;

@Service
public class PrivilegeResourceBaseApiServiceImpl implements IPrivilegeResourceBaseApiService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ModuleMapper moduleMapper;
	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public String getModuleTree(Integer userId, String visitedModule, String visitedResource) {
		if (visitedModule == null)
			visitedModule = "";
		if (visitedResource == null)
			visitedResource = "";

		User user = userMapper.selectByPrimaryKey(userId);
		if (user == null)
			return "";

		List<Module> moduleList;
		if (user.getIsAdmin()) {
			moduleList = moduleMapper.getModuleList();
		} else {
			moduleList = moduleMapper.getModuleListByUserId(userId);
		}
		if (moduleList == null || moduleList.size() == 0)
			return "";
		List<Resource> resourceList;
		if (user.getIsAdmin()) {
			resourceList = resourceMapper.getResourceList();
		} else {
			List<String> moduleFlags = new ArrayList<String>();
			for (Module m : moduleList) {
				moduleFlags.add(m.getFlag());
			}
			resourceList = resourceMapper.getResourceListByModuleFlag(moduleFlags, userId);
		}

		// 从前一页面传过来的ModuleFlag标记和visitedStructure标记
		// moduleFlag = "p";
		// visitedStructure = "s-1-1-1";
		List<Resource> list = mergeResources(resourceList, null);

		for (Resource resource : list) {
			System.out.println(resource.toString());
		}

		return "";
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
	private List<Resource> mergeResources(List<Resource> resources, Integer ignoreType) {

		List<Resource> result = Lists.newArrayList();
		for (Resource resource : resources) {
			Integer parentId = (Integer) resource.getParentId();
			Integer type = resource.getType();

			// parentId为0, 则为根节点
			if (parentId == 0 && (ignoreType == null || !ignoreType.equals(type))) {
				recursionResource(resource, resources, ignoreType);
				result.add(resource);
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
	private void recursionResource(Resource parent, List<Resource> resources, Integer ignoreType) {

		List<Resource> resourceList = Lists.newArrayList();
		parent.setChildResource(resourceList);

		for (Resource resource : resources) {
			Integer parentId = resource.getParentId();

			// 当为根节点时
			if (parentId == 0) {
				continue;
			}
			if ((ignoreType == null || !ignoreType.equals(resource.getType())) && parentId.equals(parent.getId())) {
				recursionResource(resource, resources, ignoreType);
				List<Resource> children = parent.getChildResource();
				if (children != null) {
					resource.setParent(parent);
					children.add(resource);
				}
			}
		}
	}

}
