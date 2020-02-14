package com.x2yu.circle.service;

import com.x2yu.circle.entity.TblBookInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 书籍信息表  服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-14
 */
public interface ITblBookInfoService extends IService<TblBookInfo> {

    /**
     * 获取首页展示最新10本书籍
     * */
    public List<TblBookInfo> getHomeBooks();
}
