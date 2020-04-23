package com.x2yu.circle.mapper;

import com.x2yu.circle.entity.TblCircleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 圈子信息表  Mapper 接口
 * </p>
 *
 * @author x2yu
 * @since 2020-04-09
 */
public interface TblCircleInfoMapper extends BaseMapper<TblCircleInfo> {

    @Select("SELECT * FROM tbl_circle_info WHERE id >= ((SELECT MAX(id) FROM tbl_circle_info)-(SELECT MIN(id) FROM tbl_circle_info)) * RAND() + (SELECT MIN(id) FROM tbl_circle_info)  LIMIT 10")
    List<TblCircleInfo> getRandomCircleInfo();
}
