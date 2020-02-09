package com.x2yu.circleapi.dao;

import com.x2yu.circleapi.pojo.SecUserRole;
import com.x2yu.circleapi.pojo.SecUserRoleExample;
import java.util.List;

public interface SecUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecUserRole record);

    int insertSelective(SecUserRole record);

    List<SecUserRole> selectByExample(SecUserRoleExample example);

    SecUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecUserRole record);

    int updateByPrimaryKey(SecUserRole record);
}