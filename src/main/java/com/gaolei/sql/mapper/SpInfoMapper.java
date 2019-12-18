package com.gaolei.sql.mapper;

import com.gaolei.sql.pojo.SpInfo;

import java.util.List;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/16 10:51
 */
public interface SpInfoMapper {
   List<String> findAllCompanyName();
   String findSpIdBySpName(String sp_name);
   void addSpInfo(SpInfo spInfo);
}
