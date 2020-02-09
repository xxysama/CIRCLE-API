package com.x2yu.circleapi.controller;

import com.x2yu.circleapi.pojo.User;
import com.x2yu.circleapi.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * @Author: x2yu
 * @Date: 2020/2/7 14:54
 * @Describe：
 */

@Controller
public class LoginController {

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User user){
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", user.getPassword())) {
            String message = "账号密码错误";
            System.out.println("登陆测试");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
