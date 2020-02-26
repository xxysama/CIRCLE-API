package com.x2yu.circle.service;

import com.x2yu.circle.entity.TblAuthorInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 作者信息表  服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-26
 */
public interface ITblAuthorInfoService extends IService<TblAuthorInfo> {

    /**
     * 作者信息根据描述模糊搜索
     * */
    public List<TblAuthorInfo> getAuthorBySearch(String des);
}
