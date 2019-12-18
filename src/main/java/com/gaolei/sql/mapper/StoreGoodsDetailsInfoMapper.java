package com.gaolei.sql.mapper;

import com.gaolei.sql.pojo.StoreGoodsDetailsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/11 11:06
 */
public interface StoreGoodsDetailsInfoMapper {
    void addStoreGoodsDetailsInfo(@Param(value = "storeGoodsDetailsInfos") List<StoreGoodsDetailsInfo> storeGoodsDetailsInfos);
}
