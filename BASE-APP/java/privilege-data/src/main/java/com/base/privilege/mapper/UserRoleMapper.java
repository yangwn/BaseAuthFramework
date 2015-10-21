package com.base.privilege.mapper;

import com.base.privilege.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}