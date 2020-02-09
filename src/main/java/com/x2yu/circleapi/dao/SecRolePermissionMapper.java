package com.x2yu.circleapi.dao;

import com.x2yu.circleapi.pojo.SecRolePermission;
import com.x2yu.circleapi.pojo.SecRolePermissionExample;
import java.util.List;

public interface SecRolePermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecRolePermission record);

    int insertSelective(SecRolePermission record);

    List<SecRolePermission> selectByExample(SecRolePermissionExample example);

    SecRolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecRolePermission record);

    int updateByPrimaryKey(SecRolePermission record);
}