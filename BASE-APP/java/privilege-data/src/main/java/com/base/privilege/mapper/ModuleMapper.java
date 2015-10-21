package com.base.privilege.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.privilege.model.Module;

/**
 * 模块维护
 * 
 * @author Bruce.Yang
 */
public interface ModuleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Module record);

	int insertSelective(Module record);

	Module selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Module record);

	int updateByPrimaryKey(Module record);

	/**
	 * 获取所有Module
	 * 
	 * @return
	 */
	List<Module> getModuleList();

	/**
	 * 根据flag获取Module
	 * 
	 * @param flag
	 * @return
	 */
	List<Module> getModuleListByFlag(@Param("flag") String flag);

	/**
	 * 查询roleId具有权限的模块列表
	 * 
	 * @param roleId
	 * @return
	 */
	List<Module> getModuleListByRoleId(Integer roleId);

	/**
	 * 查询userId具有权限的模块列表
	 * 
	 * @param userId
	 * @return
	 */
	List<Module> getModuleListByUserId(Integer userId);
}