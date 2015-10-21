package com.base.privilege.biz.external;


public interface IPrivilegeResourceBaseApiService {

	String getModuleTree(Integer userId, String visitedModule, String visitedResource);
}
