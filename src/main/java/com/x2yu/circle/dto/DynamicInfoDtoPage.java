package com.x2yu.circle.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2020/5/5 18:20
 * @Describe：
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DynamicInfoDtoPage {

    /**
     * 分页书籍数据
     */
    private List<DynamicInfoDto> records;


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
