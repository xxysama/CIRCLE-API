package com.x2yu.circle.service;

import com.x2yu.circle.entity.TblCircleMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 圈子成员表  服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-04-09
 */
public interface ITblCircleMemberService extends IService<TblCircleMember> {

    /**
     * 判断当前用户是否已经加入小组
     * */
    public boolean alreadyApplyCircle(Integer circleId,Integer memberId);
}
