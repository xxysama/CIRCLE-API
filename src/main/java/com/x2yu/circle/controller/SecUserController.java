package com.x2yu.circle.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.x2yu.circle.dto.UserInfoResetDto;
import com.x2yu.circle.entity.SecUser;
import com.x2yu.circle.entity.TblUserLike;
import com.x2yu.circle.service.ISecUserRoleService;
import com.x2yu.circle.service.ISecUserService;
import com.x2yu.circle.utils.Result;
import com.x2yu.circle.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
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
    @Autowired
    ISecUserRoleService userRoleService;

    @GetMapping("list")
    @ApiOperation("获取用户列表")
    public List<SecUser> getUserList(){

        return userService.list();
    }

    @GetMapping("list/{page}")
    @ApiOperation("获取用户列表")
    @ApiImplicitParam(name = "page",value = "页码",required = true,dataType = "Integer")
    public  IPage<SecUser> getUserListByPage(@PathVariable("page")Integer page){

        // 分页查询每页的数据量
        Integer pageSize = 5;
        Page<SecUser> userPage = new Page<>(page,pageSize);

        IPage<SecUser> userIPage = userService.page(userPage);

        return userIPage;
    }

    @PostMapping("search/{page}")
    @ApiOperation("搜索获取用户列表")
    public IPage<SecUser> searchUserByDes(@RequestBody SecUser user,@PathVariable("page")Integer page){

        Integer pageSize = 5;
        Page<SecUser> userPage = new Page<>(page,pageSize);

        IPage<SecUser> userIPage = userService.searchUserByDes(user,page);

        return userIPage;

    }


    @PutMapping("active")
    @ApiOperation("改变用户状态")
    public Result changeUserActive(@RequestBody SecUser user){
        Integer uid = user.getUserId();
        try {
            user = userService.getById(uid);
            user.setActive(!user.getActive());
            userService.updateById(user);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.submitError();
        }

    }

    @DeleteMapping("delete")
    @ApiOperation("注销指定用户")
    public Result deleteUserById(@RequestBody SecUser user){
        Integer uid = user.getUserId();
        try {
            // 先删除关联表信息
            userRoleService.deleteUserRelByUid(uid);
            // 删除主表信息
            userService.removeById(uid);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.submitError();
        }
    }

    @PutMapping("update")
    @ApiOperation("更新用户基本资料")
    public Result updateUserInfo(@RequestBody SecUser user){

        // 查询用户信息
         SecUser oldUser = userService.getById(user.getUserId());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = oldUser.getUpdatedTime();
        Duration duration = Duration.between(start,now);
        long days = duration.toDays(); //相差的天数

        // 30天内只能更新一次
        if(days >= 30){
            try {
                oldUser.setUserName(user.getUserName());
                String email = user.getEmail()==null || user.getEmail().length() <=0  ? oldUser.getEmail(): user.getEmail();
                oldUser.setEmail(email);

                userService.updateById(oldUser);
                return ResultUtil.success();
            } catch (Exception e) {
                e.printStackTrace();
                return ResultUtil.submitError();
            }
        }else {
            String  msg = (30-days)+"日后可修改昵称";
            return ResultUtil.submitError(msg);
        }
    }

    @PutMapping("passReset")
    @ApiOperation("重置密码")
    public Result passReset(@RequestBody UserInfoResetDto userInfoResetDto){

        try {
            //执行获取旧密码

            // 验证通过证明旧密码正确
            SecUser user = userService.getById(userInfoResetDto.getUserId());

            String oldSalt = user.getSalt();
            // 默认迭代两次 计算用户输入的密码
            String inputOldPass = new SimpleHash("md5",userInfoResetDto.getOldPass(),oldSalt,2).toString();
            String oldPass = user.getPassword();

            // 比较是否与旧密码相等
            if(oldPass.equals(inputOldPass)){
                // 验证通过进行修改
                // 生成盐，默认长度为16
                String salt = new SecureRandomNumberGenerator().nextBytes().toString();
                // 设置hash迭代次数
                int times =2;

                //得到Hash 后的密码
                String encodedPassword = new SimpleHash("md5",userInfoResetDto.getNewPass(),salt,times).toString();
                user.setPassword(encodedPassword);
                user.setSalt(salt);

                userService.updateById(user);
                return ResultUtil.success();
            }else{
                return ResultUtil.incorrectPass();
            }


        }  catch ( Exception e) {
            // 提交错误
            return ResultUtil.submitError();
        }


    }
}
