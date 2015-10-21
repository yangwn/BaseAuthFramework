package com.cfilmcloud.auth.base.shiro;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.base.privilege.model.User;
import com.cfilmcloud.auth.base.commons.SessionVariableUtils;
import com.cfilmcloud.auth.base.exception.ServiceException;
import com.cfilmcloud.auth.base.privilege.extrenal.service.IResourceService;
import com.cfilmcloud.auth.base.privilege.extrenal.service.IRoleService;
import com.cfilmcloud.auth.base.privilege.extrenal.service.IUserService;

public class AuthorizationCasRealm extends CasRealm {

	@Autowired
	private IResourceService iresourceService;

	@Autowired
	private IRoleService iroleService;

	@Autowired
	private IUserService iuserService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		if (StringUtils.isEmpty(username)) {
			throw new ServiceException("当前不存在用户");
		}
		
		Set<String> roleSet = iroleService.getRoleListByUserName(username); //XXX 修改为dubbo接口
		User user = iuserService.getUserByName(username); //XXX 修改为dubbo接口
		
		// start 从Session中直接获取关于用户的属性信息
		SessionVariableUtils sessionVariable = new SessionVariableUtils(user);
		sessionVariable.setRoleSet(roleSet);
		sessionVariable.setMenusList(iresourceService.getResourceTreeByUserName(user.getId())); //XXX 修改为dubbo接口
		SecurityUtils.getSubject().getSession().setAttribute(SessionVariableUtils.DEFAULT_SESSION_KEY, sessionVariable);
		// end 从Session中直接获取关于用户的属性信息

		NavAuthorizationInfo authorizationInfo = new NavAuthorizationInfo();
		authorizationInfo.setRoles(roleSet); //XXX 修改为dubbo接口
		authorizationInfo.addStringPermissions(iresourceService.getPermissionsByUserName(username)); //XXX 修改为dubbo接口
		authorizationInfo.addNavs(iresourceService.getResourceTreeByUserName(user.getId())); //XXX 修改为dubbo接口
		return authorizationInfo;
	}

	/**
	 * 用户与密码认证
	 * @param authcToken 用户信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
		return super.doGetAuthenticationInfo(authcToken);
	}

	/**
	 * 获取授权信息类
	 *
	 * @param principals
	 *            shiro 当事人(当前用户)集合
	 *
	 * @return 授权信息类
	 */
	public AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		return super.getAuthorizationInfo(principals);
	}
}
