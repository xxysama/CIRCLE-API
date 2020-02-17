package com.x2yu.circle.service;

import com.x2yu.circle.entity.TblCarouselInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 走马灯展示信息表 服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-17
 */
public interface ITblCarouselInfoService extends IService<TblCarouselInfo> {

    /**
     * 获取书籍走马灯展示信息
     */
    public List<TblCarouselInfo> getBookCarouselInfo();
}
