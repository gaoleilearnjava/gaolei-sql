package com.gaolei.sql.service;

import com.gaolei.sql.mapper.*;
import com.gaolei.sql.pojo.*;
import com.gaolei.sql.utils.Base64Utils;
import com.gaolei.sql.utils.DownloadAndUploadUtils;
import com.gaolei.sql.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/11 11:54
 */
@Transactional
public class StoreGoodsService {
    @Autowired
    private StoreGoodsMapper storeGoodsMapper;
    @Autowired
    private HbProductMapper hbProductMapper;
    @Autowired
    private StoreGoodsDetailsInfoMapper storeGoodsDetailsInfoMapper;
    @Autowired
    private StorePicInfoMapper storePicInfoMapper;
    @Autowired
    private SpInfoMapper spInfoMapper;
    @Autowired
    private SysFileRecMapper sysFileRecMapper;

    public void saveStoreGoods() throws Exception {
        //从爬虫数据库查询所有数据
        List<HbProduct> hbProducts = hbProductMapper.findAll();
        //新建一个storegoodsList
        List<StoreGoods> storeGoodslist = new ArrayList<StoreGoods>();
        //新建一个detailInfoList
        List<StoreGoodsDetailsInfo> storeGoodsDetailsInfoList = new ArrayList<StoreGoodsDetailsInfo>();
        //获取到所有的已存在的商品名称
        List<String> allNames = storeGoodsMapper.findAll();
        //新建了一个PicList
        List<StorePicInfo> storePicInfosList = new ArrayList<StorePicInfo>();
        for (HbProduct hbProduct : hbProducts) {
            String product_name = hbProduct.getProduct_name();
            product_name.replace(" ", "");
            //如果商品不存在就存入数据库
            if (!allNames.contains(product_name)) {
                //保存到商品表
                StoreGoods storeGoods = new StoreGoods();
                storeGoods.setGoodsId(UuidUtils.getUUID());
                storeGoods.setGoodsName(product_name);
                //对SPID进行判断去重
                List<String> allCompanyName = spInfoMapper.findAllCompanyName();
                if (!allCompanyName.contains(hbProduct.getProduct_company())) {
                    SpInfo spInfo = new SpInfo();
                    spInfo.setSp_name(hbProduct.getProduct_name());
                    spInfo.setSp_id(UuidUtils.getUUID());
                    spInfo.setSp_status(1);
                    spInfo.setSp_activity(0);
                    spInfo.setSp_source(1);
                    spInfo.setSp_update_user(spInfo.getSp_id());
                    spInfoMapper.addSpInfo(spInfo);
                    storeGoods.setSpId(spInfo.getSp_id());
                } else {
                    String sp_id = spInfoMapper.findSpIdBySpName(hbProduct.getProduct_company());
                    storeGoods.setSpId(sp_id);
                }

                storeGoods.setGoodsUpOrLow(0);
                storeGoods.setGoodsSort(10000);
                storeGoods.setGoodsCreateUser(storeGoods.getSpId());
                storeGoods.setGoodsSource(1);
                storeGoodslist.add(storeGoods);

                //保存到商品详情表
                StoreGoodsDetailsInfo storeGoodsDetailsInfo = new StoreGoodsDetailsInfo();
                storeGoodsDetailsInfo.setGoodsId(storeGoods.getGoodsId());
                storeGoodsDetailsInfo.setGoodsDetails(Base64Utils.encode(hbProduct.getProduct_detail().getBytes()));
                storeGoodsDetailsInfoList.add(storeGoodsDetailsInfo);


                // 把图片存到fastdfs上，获取到地址，根据地址生成file_id ,并保存到sys_file_rec表，返回fileid，
                //获取图片的URL
                List<String> picUrlList = new ArrayList<String>();
                String product_pic1 = hbProduct.getProduct_pic1();
                String product_pic2 = hbProduct.getProduct_pic2();
                String product_pic3 = hbProduct.getProduct_pic3();
                String product_pic4 = hbProduct.getProduct_pic4();
                String product_pic5 = hbProduct.getProduct_pic5();
                if (product_pic1 != null) {
                    picUrlList.add(product_pic1);
                }
                if (product_pic2 != null) {
                    picUrlList.add(product_pic2);
                }
                if (product_pic3 != null) {
                    picUrlList.add(product_pic3);
                }
                if (product_pic4 != null) {
                    picUrlList.add(product_pic4);
                }
                if (product_pic5 != null) {
                    picUrlList.add(product_pic5);
                }
                for (String strUrl : picUrlList) {
                    //将图片存到DFS中，返回DFS中的URL
                    String dfsUrl = DownloadAndUploadUtils.downloadPicture(strUrl);
                    SysFileRec sysFileRec = new SysFileRec();
                    sysFileRec.setFile_id(UuidUtils.getUUID());
                    sysFileRec.setFile_path(dfsUrl);
                    String[] strings = dfsUrl.split("\\.");
                    String exname = strings[strings.length - 1];
                    sysFileRec.setFile_exname(exname);
                    sysFileRecMapper.addSysFileRec(sysFileRec);
                    //保存到图片表
                    StorePicInfo storePicInfo = new StorePicInfo();
                    storePicInfo.setGoods_id(storeGoods.getGoodsId());
                    storePicInfo.setGoods_default_pic(1);
                    storePicInfo.setGoods_pic_id(sysFileRec.getFile_id());
                    storePicInfosList.add(storePicInfo);
                }
            }
        }
        storeGoodsMapper.saveStoreGoods(storeGoodslist);
        storeGoodsDetailsInfoMapper.addStoreGoodsDetailsInfo(storeGoodsDetailsInfoList);
        storePicInfoMapper.saveStorePicInfo(storePicInfosList);
    }
}
