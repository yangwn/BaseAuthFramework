package com.base.privilege.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.privilege.model.Department;

/**
 * 部门维护
 * 
 * @author Bruce.Yang
 */
public interface DepartmentMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(Department record);

	int insertSelective(Department record);

	Department selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Department record);

	int updateByPrimaryKey(Department record);

	/**
	 * 查询所有Department对象
	 * 
	 * @return
	 */
	List<Department> getDepartmentList();
	/**
	 * 查询所有Department对象
	 * 
	 * @return
	 */
	List<Department> getDepartmentListByParentId(@Param("parentId") Integer parentId);
	/**
	 * 部门是否被用户使用
	 * 
	 * @param departmentId
	 */
	Boolean isUsedByUser(Integer departmentId);
}