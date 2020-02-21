package com.x2yu.circle.dto;

import com.x2yu.circle.entity.TblTagInfo;
import com.x2yu.circle.entity.TblTagItem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: x2yu
 * @Date: 2020/2/21 15:03
 * @Describe：
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TagsItemDto {

   private TblTagInfo tblTagInfo;

   private List<TblTagItem> tagItemList;

}
