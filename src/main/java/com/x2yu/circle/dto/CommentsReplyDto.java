package com.x2yu.circle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: x2yu
 * @Date: 2020/3/3 15:35
 * @Describe：
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommentsReplyDto  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 回复用户id
     */
    private Integer fromUid;


    /**
     * 目标用户id
     */
    private Integer toUid;

    /**
     * 回复用户名
     */
    private String fromUserName;

    /**
     * 目标用户名
     */
    private String toUserName;


    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime replyTime;


}
