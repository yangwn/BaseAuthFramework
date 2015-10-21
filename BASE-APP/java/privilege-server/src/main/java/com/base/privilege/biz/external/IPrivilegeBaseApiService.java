package com.base.privilege.biz.external;

import com.base.privilege.model.User;

public interface IPrivilegeBaseApiService {

	User getUserByUsername(String username);
	
	String getModuleTree(Integer userId,String visitedModule,String visitedResource);
	
	Integer updateUserById(User user);
}
