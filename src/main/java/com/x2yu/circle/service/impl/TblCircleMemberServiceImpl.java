package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.TblCircleMember;
import com.x2yu.circle.mapper.TblCircleMemberMapper;
import com.x2yu.circle.service.ITblCircleMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 圈子成员表  服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-04-09
 */
@Service
public class TblCircleMemberServiceImpl extends ServiceImpl<TblCircleMemberMapper, TblCircleMember> implements ITblCircleMemberService {

    @Autowired
    TblCircleMemberMapper circleMemberMapper;

    @Override
    public boolean alreadyApplyCircle(Integer circleId, Integer memberId) {

        QueryWrapper<TblCircleMember> wrapper = new QueryWrapper<>();
        wrapper.eq("circle_id",circleId)
                .eq("member_id",memberId);

        if(circleMemberMapper.selectList(wrapper).isEmpty()){
            // 为空 未加入
            return false;
        }else{
            // 不为空 已经加入
            return true;
        }
    }
}
