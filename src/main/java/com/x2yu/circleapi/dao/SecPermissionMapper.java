package com.x2yu.circleapi.dao;

import com.x2yu.circleapi.pojo.SecPermission;
import com.x2yu.circleapi.pojo.SecPermissionExample;
import java.util.List;

public interface SecPermissionMapper {
    int deleteByPrimaryKey(Integer permission_id);

    int insert(SecPermission record);

    int insertSelective(SecPermission record);

    List<SecPermission> selectByExample(SecPermissionExample example);

    SecPermission selectByPrimaryKey(Integer permission_id);

    int updateByPrimaryKeySelective(SecPermission record);

    int updateByPrimaryKey(SecPermission record);
}