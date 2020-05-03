package com.x2yu.circle.service;

import com.x2yu.circle.dto.DynamicInfoDto;
import com.x2yu.circle.entity.TblDynamicInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 动态信息表 服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-04-25
 */
public interface ITblDynamicInfoService extends IService<TblDynamicInfo> {

    /**
     * 滚动加载
     * */
    public List<TblDynamicInfo> listDynamicScroll(List<Integer> ids,Integer index);


    public Integer countDynamicByUserIds(List<Integer> ids);
}
