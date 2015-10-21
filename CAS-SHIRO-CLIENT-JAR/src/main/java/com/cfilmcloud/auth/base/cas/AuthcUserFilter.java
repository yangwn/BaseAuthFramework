package com.cfilmcloud.auth.base.cas;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.cfilmcloud.auth.base.commons.Constants;
import com.cfilmcloud.auth.base.privilege.extrenal.service.IUserService;

public class AuthcUserFilter extends PathMatchingFilter {

	@Autowired
	private IUserService userService;

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		request.setAttribute(Constants.CURRENT_USER, userService.getUserByName(username));
		return true;
	}
}