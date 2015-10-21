package com.cfilmcloud.auth.base.privilege.extrenal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.privilege.mapper.RoleMapper;
import com.base.privilege.model.Role;
import com.google.common.collect.Sets;

@Service
public class IRoleServiceImpl implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public Set<String> getRoleListByUserName(String username) {
		Set<String> roleSet = Sets.newHashSet();
		List<Role> roleList = roleMapper.getRoleListByUserName(username);
		for (Role role : roleList) {
			roleSet.add(role.getName());
		}
		return roleSet;
	}

}
