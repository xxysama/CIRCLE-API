package com.x2yu.circleapi.dao;

import com.x2yu.circleapi.pojo.SecUser;
import com.x2yu.circleapi.pojo.SecUserExample;
import java.util.List;

public interface SecUserMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(SecUser record);

    int insertSelective(SecUser record);

    List<SecUser> selectByExample(SecUserExample example);

    SecUser selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(SecUser record);

    int updateByPrimaryKey(SecUser record);
}