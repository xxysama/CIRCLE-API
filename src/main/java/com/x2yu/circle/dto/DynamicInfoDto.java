package com.x2yu.circle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2020/5/3 20:10
 * @Describe：
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DynamicInfoDto  implements Serializable {
    /**
     * 动态id
     */
    private Integer dynamicId;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 内容
     */
    private String content;


    /**
     * 图片集合
     * */
    private List<String> pictureList;

    /**
     * 点赞数
     */
    private Integer likeNum;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 回复条数
     */
    private Integer replyCount;



}
