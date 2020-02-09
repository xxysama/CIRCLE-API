package com.x2yu.circleapi.dao;

import com.x2yu.circleapi.pojo.SecRole;
import com.x2yu.circleapi.pojo.SecRoleExample;
import java.util.List;

public interface SecRoleMapper {
    int deleteByPrimaryKey(Integer role_id);

    int insert(SecRole record);

    int insertSelective(SecRole record);

    List<SecRole> selectByExample(SecRoleExample example);

    SecRole selectByPrimaryKey(Integer role_id);

    int updateByPrimaryKeySelective(SecRole record);

    int updateByPrimaryKey(SecRole record);
}