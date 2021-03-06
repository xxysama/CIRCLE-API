package com.x2yu.circle.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.x2yu.circle.entity.SecUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author x2yu
 * @since 2020-02-10
 */
public interface SecUserMapper extends BaseMapper<SecUser> {

    @Select("select * from sec_user ${ew.customSqlSegment}")
    List<SecUser> queryExistUser(@Param(Constants.WRAPPER) Wrapper wrapper);
}
