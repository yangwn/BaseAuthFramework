package com.cfilmcloud.auth.base.privilege.extrenal.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.base.privilege.model.Resource;

public interface ResourceService {

	public Set<String> getPermissionsByUserName(String username);

	public List<Resource> getResourcesByUserName(String username);

	public List<Map<String, Object>> getResourceTreeByUserName(Integer userId);
}
