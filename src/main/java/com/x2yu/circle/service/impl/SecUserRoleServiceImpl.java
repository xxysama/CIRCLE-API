package com.x2yu.circle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.SecUserRole;
import com.x2yu.circle.mapper.SecUserRoleMapper;
import com.x2yu.circle.service.ISecUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表  服务实现类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-10
 */
@Service
public class SecUserRoleServiceImpl extends ServiceImpl<SecUserRoleMapper, SecUserRole> implements ISecUserRoleService {

    @Autowired
    SecUserRoleMapper userRoleMapper;

    @Override
    public void deleteUserRelByUid(Integer uid) {
        QueryWrapper<SecUserRole> wrapper = new QueryWrapper();
        wrapper.eq("user_id",uid);
        userRoleMapper.delete(wrapper);
    }
}
