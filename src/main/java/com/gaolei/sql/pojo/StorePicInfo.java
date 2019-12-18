package com.gaolei.sql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/11 14:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorePicInfo {
    private String goods_id;
    private String goods_pic_id;
    private Integer goods_default_pic;
}
