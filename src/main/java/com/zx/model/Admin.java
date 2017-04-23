package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Xin on 2017/3/5.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    private Integer aid;
    private String aname;
    private String apassword;
    private Integer adel;


}
