package com.gaolei.sql.mapper;

import com.gaolei.sql.pojo.StorePicInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/11 14:13
 */
public interface StorePicInfoMapper {
    void saveStorePicInfo(@Param(value = "storePicInfos") List<StorePicInfo> storePicInfos);
    void saveSingleStorePicInfo(StorePicInfo storePicInfo);
}
