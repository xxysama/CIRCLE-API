package com.x2yu.circle.mapper;

import com.x2yu.circle.entity.TblBookInfo;
import com.x2yu.circle.entity.TblCarouselInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 走马灯展示信息表 Mapper 接口
 * </p>
 *
 * @author x2yu
 * @since 2020-02-17
 */
public interface TblCarouselInfoMapper extends BaseMapper<TblCarouselInfo> {

    @Select("select * from tbl_carousel_info where type = 'book' order by created_time desc limit 4")
    List<TblCarouselInfo> getBookCarouselInfo();
}
