package com.x2yu.circle.controller;

import com.x2yu.circle.utils.QiniuUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: x2yu
 * @Date: 2020/4/24 23:23
 * @Describe：
 */

@RestController
@RequestMapping("api/qiniu/")
public class QiniuController {

    @GetMapping("token")
    public String getUploadToken(){
        return QiniuUtil.getUploadToken();
    }
}
