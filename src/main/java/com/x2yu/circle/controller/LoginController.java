package com.x2yu.circle.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.SecRole;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.SecUserRole;
import com.x2yu.circle.entity.User;
import com.x2yu.circle.service.ISecRoleService;
import com.x2yu.circle.service.ISecUserRoleService;
import com.x2yu.circle.service.ISecUserService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * @Author: x2yu
 * @Date: 2020/2/7 14:54
 * @Describe：
 */

@Controller
@CrossOrigin
public class LoginController {

    @Autowired
    ISecRoleService roleService;
    @Autowired
    ISecUserService userService;
    @Autowired
    ISecUserRoleService userRoleService;

    @ResponseBody
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User user){
//        String username = user.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//
//        if (!Objects.equals("admin", username) || !Objects.equals("123456", user.getPassword())) {
//            String message = "账号密码错误";
//            System.out.println("登陆测试");
//            return new Result(400);
//        } else {
//            return new Result(200);
//        }
        return ResultUtil.success();
    }

    @ResponseBody
    @GetMapping(value = "api/testRole")
    public SecRole getSecRole(){
        SecRole secRole = roleService.getById(1);
        return secRole;
    }

    @ResponseBody
    @PostMapping("api/register")
    public Result register(@RequestBody SecUser secUser){
        try {
            //先查询是否注册过 然后注册
            while(userService.existUser(secUser)){
                System.out.println("没有注册过！");
                userService.save(secUser);

                SecUserRole secUserRole = new SecUserRole();
                secUserRole.setRoleId(1);//默认注册为普通用户
                QueryWrapper<SecUser> queryWrapper = new QueryWrapper<>();
                queryWrapper.ge("email",secUser.getEmail());
                int userId = userService.getOne(queryWrapper).getUserId();
                secUserRole.setUserId(userId);

                userRoleService.save(secUserRole);
                return ResultUtil.registerSuccess();
            }
            System.out.println("已经注册过了！");
            return ResultUtil.registerError();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.dataBaseError();
        }
    }
}
