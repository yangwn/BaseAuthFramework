package com.cfilmcloud.auth.base.privilege.extrenal.service;

import java.util.Set;

public interface IRoleService {

	public Set<String> getRoleListByUserName(String username);

}
