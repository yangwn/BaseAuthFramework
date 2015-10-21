package com.cfilmcloud.auth.base.shiro;

import java.util.List;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.base.privilege.mapper.ResourceMapper;
import com.base.privilege.model.Resource;

public class ChainDefinitionSectionMetaSource implements FactoryBean<Section> {

	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public Section getObject() throws BeansException {
		// 加载默认资源控制
		Ini ini = new Ini();
		ini.load(filterChainDefinitions);
		Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
		if (CollectionUtils.isEmpty(section)) {
			section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		}
		// 从数据库中加载资源控制
		List<Resource> resourceList = resourceMapper.getResourceList();
		for (Resource resource : resourceList) {
			section.put(resource.getUrl(), resource.getPermission());
		}
		return section;
	}

	@Override
	public Class<Section> getObjectType() {
		return Section.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	private String filterChainDefinitions;

	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}
}