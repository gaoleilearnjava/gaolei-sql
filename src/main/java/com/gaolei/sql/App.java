package com.gaolei.sql;

import com.gaolei.sql.service.StoreGoodsService;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/11 10:40
 */
public class App {
    public static void main(String[] args) throws Exception {
        StoreGoodsService storeGoodsService = new StoreGoodsService();
        storeGoodsService.saveStoreGoods();
    }
}
