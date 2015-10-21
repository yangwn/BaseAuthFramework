package com.cfilmcloud.auth.base.test.webservice;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfilmcloud.auth.base.commons.SessionVariableUtils;
import com.google.common.collect.Maps;

@Controller
@RequiresAuthentication
@RequestMapping(value = "admin")
public class AdminWebService {

	@ResponseBody
	@RequiresPermissions(value = { "user:ass", "user:b" }, logical = Logical.AND)
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public Map<String, String> test1() {
		System.out.println("test2........:");
		Map<String, String> mapData = Maps.newConcurrentMap();
		mapData.put("22", "333");
		return mapData;
	}
	
	@ResponseBody
	@RequestMapping(value = "resource", method = RequestMethod.GET)
	public List<Map<String, Object>> test2() {
		return SessionVariableUtils.getCurrentSessionVariable().getMenusList();
	}
}
