package com.x2yu.circle.service;

import com.x2yu.circle.entity.TblCircleInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 圈子信息表  服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-04-09
 */
public interface ITblCircleInfoService extends IService<TblCircleInfo> {

    /***
     * 获取首页展示小组信息
     * @return
     */
    public List<TblCircleInfo> getTopCircleInfo(Integer cid);

    /***
     * 获取最热门展示小组信息
     * @return
     */
    public List<TblCircleInfo> getTopicCircleInfo();
}
