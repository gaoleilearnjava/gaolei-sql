package com.gaolei.sql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/16 10:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpInfo {
    private String sp_id;
    private String sp_name;
    private String sp_name_en;
    private String sp_region;
    private String sp_addr;
    private String sp_office_phone;
    private String sp_contacts;
    private String sp_mobile_phone;
    private String sp_email;
    private String sp_note;
    private String sp_introduce;
    private String sp_pic;
    private String sp_logo;
    private Date sp_create_time;
    private String sp_examine_user;
    private Integer sp_status;
    private String sp_py;
    private Integer sp_activity;
    private Integer sp_sort;
    private String sp_capital;
    private String sp_coordinate;
    private String sp_zip_code;
    private String sp_fax;
    private String sp_website;
    private Integer sp_nationality;
    private Integer sp_source;
    private String sp_update_user;
    private Date sp_update_time;
}
