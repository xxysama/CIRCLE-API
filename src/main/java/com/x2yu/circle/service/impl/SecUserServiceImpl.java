package com.x2yu.circle.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.mapper.SecUserMapper;
import com.x2yu.circle.service.ISecUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-10
 */
@Service
public class SecUserServiceImpl extends ServiceImpl<SecUserMapper, SecUser> implements ISecUserService {

    @Autowired
    SecUserMapper userMapper;
    @Override
    public Boolean existUser(SecUser user) {

        Integer count = userMapper.selectCount(Wrappers.<SecUser>lambdaQuery().eq(SecUser::getEmail,user.getEmail()));
        if(count>=1){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean existUsername(SecUser user) {

        Integer count = userMapper.selectCount(Wrappers.<SecUser>lambdaQuery().eq(SecUser::getUserName,user.getUserName()));
        if(count>=1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SecUser getUserByName(String username) {
        QueryWrapper<SecUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",username);

        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<SecUser> searchUserByDes(SecUser user, Integer page) {
        // 默认5个数据一页
        int size = 5;

        // 先判断条件 如果状态为空则是默认两个都查询
        if(user.getActive() == null && user.getUserName() != null){
            String username = user.getUserName();
            QueryWrapper<SecUser> wrapper = new QueryWrapper<>();
            wrapper.like("user_name",username);

            Page<SecUser>  searPage = new Page<>(page,size);
            IPage<SecUser> iPage = userMapper.selectPage(searPage,wrapper);

            return iPage;
        }

        // 状态和搜索条件均不为空
        if(user.getActive() != null && user.getUserName() != null ){
            Boolean active = user.getActive();
            String username = user.getUserName();
            QueryWrapper<SecUser> wrapper = new QueryWrapper<>();
            wrapper.eq("active",active)
                    .like("user_name",username);
            Page<SecUser>  searPage = new Page<>(page,size);
            IPage<SecUser> iPage = userMapper.selectPage(searPage,wrapper);

            return iPage;
        }



        return null;
    }
}
