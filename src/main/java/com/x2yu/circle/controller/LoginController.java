package com.x2yu.circle.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.x2yu.circle.entity.SecRole;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.SecUserRole;
import com.x2yu.circle.service.ISecRoleService;
import com.x2yu.circle.service.ISecUserRoleService;
import com.x2yu.circle.service.ISecUserService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Result login(@RequestBody SecUser user){

        //Shiro获取当前用户
        Subject subject = SecurityUtils.getSubject();

        //封装用户登录数据
        UsernamePasswordToken token =new UsernamePasswordToken(user.getUserName(),user.getPassword());

        try {
            //执行登录
            subject.login(token);
            return ResultUtil.loginSuccess();
        } catch (UnknownAccountException e) {
            // 错误账号
            return ResultUtil.unknownAccount();
        }  catch ( IncorrectCredentialsException ice) {
            // 密码错误
            return ResultUtil.incorrectPass();
        }

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

            // 如果为真 返回提示用户名已占用
            while (userService.existUsername(secUser)){
                return ResultUtil.registerUsernameError();
            }

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
            System.out.println("邮箱已经注册过了！");
            return ResultUtil.registerEmailError();

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.dataBaseError();
        }
    }
}
