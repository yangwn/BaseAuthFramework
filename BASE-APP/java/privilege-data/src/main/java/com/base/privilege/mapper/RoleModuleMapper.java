package com.base.privilege.mapper;

import com.base.privilege.model.RoleModule;

public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}