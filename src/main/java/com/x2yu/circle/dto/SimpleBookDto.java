package com.x2yu.circle.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: x2yu
 * @Date: 2020/2/14 19:49
 * @Describe：首页展示书籍dto对象
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SimpleBookDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 书籍id
     */
    private Integer bookId;


    /**
     * 书籍名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

}
