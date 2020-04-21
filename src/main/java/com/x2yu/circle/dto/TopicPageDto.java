package com.x2yu.circle.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2020/4/20 22:56
 * @Describe：
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TopicPageDto implements Serializable {

    /**
     * 分页书籍数据
     */
    private List<CircleTopicDto> records;

    /**
     * 圈子话题总共有多少
     */
    private Long total;

    /**
     * 当前页
     */
    private Long current;


    /**
     * 总页数
     */
    private Long pages;

}
