package com.base.privilege.api;

import java.util.List;
import java.util.Map;

import com.base.privilege.model.User;

public interface IPrivilegeBaseApiService {

	/**
	 * 通过 username 获取 user info
	 * <p>
	 * Title: getUserByUsername
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);

	/**
	 * 获取Module与resource的Menu Tree,专门为Privilege前台使用
	 * 
	 * 该部分结合了javascript与css
	 * 
	 * <p>
	 * Title: getModuleTree
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param userId
	 * @param visitedModule
	 * @param visitedResource
	 * @return
	 */
	public String getModuleTree(Integer userId, String visitedModule, String visitedResource);

	/**
	 * 根据userId 更新User
	 * <p>
	 * Title: updateUserById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param user
	 * @return
	 */
	public Integer updateUserById(User user);

	/**
	 * 获取 Module 列表
	 * <p>
	 * Title: getModuleNameList
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 */
	public List<Map<String, String>> getModuleList();

	/**
	 * 通过moduleFlag 获取 Resource List
	 * 
	 * <p>
	 * Title: getResourceListByModuleName
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param moduleFlag
	 * @return
	 */
	public List<Map<String, String>> getResourceListByModuleName(String moduleFlag);

}
