package com.x2yu.circle.service;

import com.x2yu.circle.entity.TblDynamicPic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 动态图片关系表  服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-04-25
 */
public interface ITblDynamicPicService extends IService<TblDynamicPic> {

    /**
     * 根据动态id获取图片链接信息集合
     * */
    public List<String> getDynamicPics(Integer dynamicId);

}
