package com.base.privilege.mapper;

import com.base.privilege.model.RoleResource;

public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);
}