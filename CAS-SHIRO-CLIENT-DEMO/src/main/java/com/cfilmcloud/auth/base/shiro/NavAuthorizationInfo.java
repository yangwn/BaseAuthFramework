package com.cfilmcloud.auth.base.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

/**
 * 带导航的授权信息类，该类是为了辅助首页显示导航用
 */
public class NavAuthorizationInfo extends SimpleAuthorizationInfo implements Serializable {

	private static final long serialVersionUID = 8768411518474512496L;

	// 导航集合
	private List<Map<String, Object>> navs = new ArrayList<Map<String, Object>>();

	/**
	 * 带导航的授权信息类
	 */
	public NavAuthorizationInfo() {
	}

	/**
	 * 带导航的授权信息类
	 *
	 * @param navs
	 *            导航信息
	 */
	public NavAuthorizationInfo(List<Map<String, Object>> navs) {
		this.navs = navs;
	}

	/**
	 * 带导航的授权信息类
	 *
	 * @param roles
	 *            角色信息
	 * @param navs
	 *            导航信息
	 */
	public NavAuthorizationInfo(Set<String> roles, List<Map<String, Object>> navs) {
		super(roles);
		this.navs = navs;
	}

	/**
	 * 添加导航集合
	 *
	 * @param navs
	 *            导航集合
	 */
	public void addNavs(List<Map<String, Object>> navs) {
		this.navs.addAll(navs);
	}

	/**
	 * 添加导航
	 *
	 * @param mav
	 *            导航 map 实体
	 */
	public void addNav(Map<String, Object> mav) {
		this.navs.add(mav);
	}

	/**
	 * 获取导航集合
	 *
	 * @return 导航集合
	 */
	public List<Map<String, Object>> getNavs() {
		return navs;
	}

	/**
	 * 设置导航集合
	 *
	 * @param navs
	 *            导航集合
	 */
	public void setNavs(List<Map<String, Object>> navs) {
		this.navs = navs;
	}
}
