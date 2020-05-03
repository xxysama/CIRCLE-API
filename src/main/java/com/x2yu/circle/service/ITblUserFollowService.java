package com.x2yu.circle.service;

import com.x2yu.circle.entity.TblUserFollow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户关注表  服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-05-02
 */
public interface ITblUserFollowService extends IService<TblUserFollow> {

    /**
     * 根据用户id查询好友id列表
     * */
    public List<Integer> getUserFollowIds(Integer userId);
}
