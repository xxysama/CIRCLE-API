package com.x2yu.circle.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.x2yu.circle.entity.SecUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author x2yu
 * @since 2020-02-10
 */

public interface ISecUserService extends IService<SecUser> {

    //判断是否存在当前用户
    public Boolean existUser(SecUser user);

    //判断用户名是否使用
    public Boolean existUsername(SecUser user);

    //根据用户名获取用户
    public SecUser getUserByName(String username);

    //根据搜索条件分页
    public IPage<SecUser> searchUserByDes(SecUser user,Integer page);

}
