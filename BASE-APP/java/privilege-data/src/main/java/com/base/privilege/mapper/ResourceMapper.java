package com.base.privilege.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.privilege.model.Resource;

public interface ResourceMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Resource record);

	int insertSelective(Resource record);

	Resource selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Resource record);

	int updateByPrimaryKey(Resource record);

	/**
	 * 获取所有resource
	 * 
	 * @return
	 */
	List<Resource> getResourceList();

	/**
	 * 获取指定类型的所有资源:
	 * <p>
	 * Title: getResourceListByType
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param type
	 * @return
	 */
	List<Resource> getResourceListByType(@Param("type") Integer type);

	/**
	 * 根据所属模块获取资源
	 * 
	 * @return
	 */
	List<Resource> getResourceListByModuleFlag(@Param("moduleFlags") List<String> moduleFlags,
			@Param("userId") Integer userId);

	/**
	 * 根据所属模块与资源类型获取资源
	 * 
	 * @return
	 */
	List<Resource> getResourceListByModuleFlag(@Param("moduleFlags") List<String> moduleFlags,
			@Param("userId") Integer userId, @Param("type") Integer type);

	/**
	 * 根据资源id判断是否被角色使用
	 * 
	 * @param resourceId
	 * @return
	 */
	Boolean isUsedByRole(@Param("resourceId") Integer resourceId);

	/**
	 * 给定角色具有权限的资源列表
	 * 
	 * @param roleId
	 * @return
	 */
	List<Resource> getResourceListByRoleId(Integer roleId);

	/**
	 * 给定用户具有权限的资源列表
	 * 
	 * @param userName
	 * @return
	 */
	List<Resource> getResourceListByUserName(String userName);

	/**
	 * 根据parentId获取资源
	 * 
	 * @param parentId
	 * @return
	 */
	List<Resource> getResourceListByParentId(@Param("parentId") Integer parentId);
}