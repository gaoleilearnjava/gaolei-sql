package com.gaolei.sql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreGoodsDetailsInfo implements Serializable {
    private static final long serialVersionUID = 1L;


    private String goodsId;

    /**
     * 商品详情
     */

    private String goodsDetails;

    /**
     * 解决方案
     */

    private String goodsSolution;

    /**
     * 应用场景
     */
    private String goodsScene;


}