package com.cfilmcloud.auth.base.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.base.privilege.model.User;
import com.cfilmcloud.auth.base.exception.UnAutherizedException;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * session 变量对象，用于存储 httpSession 的一些常用属性，如：当前用户等
 */
@SuppressWarnings("serial")
public class SessionVariableUtils implements Serializable {

	public static final String DEFAULT_SESSION_KEY = "session_variable";
	// 当前用户
	private User user = null;
	// 当前用户的菜单集合
	private List<Map<String, Object>> menusList = Lists.newArrayList();
	// 当前用户的角色集合
	private Set<String> roleSet = Sets.newHashSet();

	/**
	 * session 变量对象
	 */
	public SessionVariableUtils(User user) {
		this.user = user;
	}

	/**
	 * 设置当前用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 获取当前用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 获取当前用户拥有的资源菜单集合
	 */
	public List<Map<String, Object>> getMenusList() {
		return menusList;
	}

	/**
	 * 设置当前用户拥有的菜单集合
	 */
	public void setMenusList(List<Map<String, Object>> menusList) {
		this.menusList = menusList;
	}

	/**
	 * 获取当前用户的角色集合
	 */
	public Set<String> getRoleSet() {
		return roleSet;
	}

	/**
	 * 设置当前用户的角色集合
	 */
	public void setRoleSet(Set<String> roleSet) {
		this.roleSet = roleSet;
	}

	/**
	 * 获取当前 session 变量对象
	 */
	public static SessionVariableUtils getCurrentSessionVariable() {
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getSession().getAttribute(SessionVariableUtils.DEFAULT_SESSION_KEY);
		if ((!subject.isAuthenticated() && !subject.isRemembered()) || principal == null) {
			throw new UnAutherizedException("用户未经过认证");
		}
		return VariableUtils.typeCast(principal);
	}
}
