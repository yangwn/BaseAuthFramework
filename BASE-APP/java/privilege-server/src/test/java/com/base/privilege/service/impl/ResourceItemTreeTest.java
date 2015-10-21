package com.base.privilege.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.base.privilege.biz.external.IPrivilegeResourceBaseApiService;
import com.base.privilege.service.ServiceTestCaseSupport;

public class ResourceItemTreeTest extends ServiceTestCaseSupport {

	@Autowired
	private IPrivilegeResourceBaseApiService iPrivilegeResourceBaseApiService;

	@Test
	public void testGetModuleTree() {
		Integer userId = 1;
		String visitedModule = "p";
		String visitedResource = "";
		String sys = iPrivilegeResourceBaseApiService.getModuleTree(userId, visitedModule, visitedResource);
		System.out.println(sys);
	}

}
