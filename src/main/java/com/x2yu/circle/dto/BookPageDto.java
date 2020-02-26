package com.x2yu.circle.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2020/2/26 20:55
 * @Describe：
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BookPageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分页书籍数据
     */
    private List<SimpleBookDto> records;


    /**
     * 书籍总共有多少
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
