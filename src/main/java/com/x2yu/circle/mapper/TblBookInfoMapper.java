package com.x2yu.circle.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.x2yu.circle.entity.TblBookInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 书籍信息表  Mapper 接口
 * </p>
 *
 * @author x2yu
 * @since 2020-02-14
 */
public interface TblBookInfoMapper extends BaseMapper<TblBookInfo> {

    @Select("select * from tbl_book_info order by publish_time desc limit 12")
    List<TblBookInfo> getHomeBooks();


    @Select("select * from tbl_book_info where author = #{author} order by rand() limit 5")
    List<TblBookInfo> getRandFiveByAuthor(@Param("author") String author);
}
