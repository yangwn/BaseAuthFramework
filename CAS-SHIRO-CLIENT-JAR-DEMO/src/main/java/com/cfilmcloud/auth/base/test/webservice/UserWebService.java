package com.cfilmcloud.auth.base.test.webservice;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.privilege.model.User;
import com.cfilmcloud.auth.base.commons.SessionVariableUtils;
import com.cfilmcloud.auth.base.commons.bind.annotation.CurrentUser;

@Controller
@RequiresAuthentication
@RequestMapping(value = "user")
public class UserWebService {

	@ResponseBody
	@RequiresRoles("CPO")
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public void test1(@CurrentUser User user) {
		System.out.println("test1........:" + user.getFullname());
		System.out.println("SessionVariable:" + SessionVariableUtils.getCurrentSessionVariable().getUser().getUsername());
	}

}
