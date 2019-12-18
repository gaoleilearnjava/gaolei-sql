package com.gaolei.sql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 高磊
 * @version 1.0
 * @date 2019/12/16 11:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysFileRec {
    private String file_id;
    private String file_path;
    private String file_name;
    private String file_exname;
}
