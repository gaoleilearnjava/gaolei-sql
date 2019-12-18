package com.gaolei.sql.mapper;

import com.gaolei.sql.pojo.StoreGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/11 11:05
 */
public interface StoreGoodsMapper {
    void saveStoreGoods(@Param("storeGoods") List<StoreGoods> storeGoods);
    List<String> findAll();
}
