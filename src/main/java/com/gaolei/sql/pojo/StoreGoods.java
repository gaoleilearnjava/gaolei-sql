package com.gaolei.sql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreGoods implements Serializable {
    private static final long serialVersionUID = 1L;


    private String goodsId;

    private String goodsName;

    /**
     * 服务商ID
     */

    private String spId;

    private String itemId;

    /**
     * 活动标志
     */

    private Integer goodsActivity;

    /**
     * 上下架标志(0-下架 1-上架 9-删除)
     */

    private Integer goodsUpOrLow;


    private Date goodsUpOrLowDate;

    /**
     * 商品排序
     */

    private Integer goodsSort;


    private String goodsCreateUser;


    private Date goodsCreateTime;


    private String goodsLastUpdateUser;


    private Date goodsLastUpdateTime;

    /**
     * 产品来源：0-本地;1-外部
     */

    private Integer goodsSource;


}