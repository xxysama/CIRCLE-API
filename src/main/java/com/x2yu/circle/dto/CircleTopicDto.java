package com.x2yu.circle.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: x2yu
 * @Date: 2020/4/20 22:57
 * @Describe：
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CircleTopicDto implements Serializable {


    /**
     * 话题标题
     */
    private String topicTitle;

    /**
     * 话题作者id
     */
    private Integer topicAuid;

    /**
     * 话题作者名称
     */
    private Integer authorName;

    /**
     * 话题内容
     */
    private String topicContent;

    /**
     * 回帖数
     */
    private Integer replyCount;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
