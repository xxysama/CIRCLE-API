package com.x2yu.circle.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: x2yu
 * @Date: 2020/3/10 22:46
 * @Describe：
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfoResetDto implements Serializable {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 旧密码
     */
    private String oldPass;


    /**
     * 新密码
     */
    private String newPass;
}
