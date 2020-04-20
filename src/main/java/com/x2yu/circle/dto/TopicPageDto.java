package com.x2yu.circle.dto;

import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2020/4/20 22:56
 * @Describe：
 */
public class TopicPageDto {

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
