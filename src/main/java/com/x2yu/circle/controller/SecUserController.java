package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.TblUserLike;
import com.x2yu.circle.service.ISecUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author x2yu
 * @since 2020-02-10
 */
@RestController
@RequestMapping("/api/user/")
public class SecUserController {

    @Autowired
    ISecUserService userService;

    @GetMapping("list")
    @ApiOperation("获取用户列表")
    public List<SecUser> getUserList(){

        return userService.list();
    }

    @GetMapping("list/{page}")
    @ApiOperation("获取用户列表")
    public  IPage<SecUser> getUserListByPage(@PathVariable("page")Integer page){

        // 分页查询每页的数据量
        Integer pageSize = 5;
        Page<SecUser> userPage = new Page<>(page,pageSize);

        IPage<SecUser> userIPage = userService.page(userPage);

        return userIPage;
    }
}
