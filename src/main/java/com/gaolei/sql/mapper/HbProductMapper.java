package com.gaolei.sql.mapper;

import com.gaolei.sql.pojo.HbProduct;

import java.util.List;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/11 11:05
 */
public interface HbProductMapper {
    List<HbProduct> findAll();
}
