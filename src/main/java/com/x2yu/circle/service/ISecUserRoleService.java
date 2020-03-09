package com.x2yu.circle.service;

import com.x2yu.circle.entity.SecUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色关系表  服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-10
 */
public interface ISecUserRoleService extends IService<SecUserRole> {

    /*
     *删除用户关系 uid为参数
     * */
    public void deleteUserRelByUid(Integer uid);
}
