package com.x2yu.circle.dto;

import com.x2yu.circle.entity.TblAuthorInfo;
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
public class DetailsBookDto implements Serializable {

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
     * 作者姓名
     */
    private String author;

    /**
     * 作者简介
     */
    private String authorIntroduction;


    /**
     * 封面
     */
    private String imgSrc;

    /**
     * 书籍简介
     */
    private String bookIntroduction;

    /**
     * 出版社
     */
    private String publisher;

    /**
     * 出版时间
     */
    private String publishTime;

    /**
     * 国际标准书号
     */
    private String isbn;

    
}
