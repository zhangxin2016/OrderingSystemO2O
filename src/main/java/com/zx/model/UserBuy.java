package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserBuy {
    private Integer uid;

    private String uname;

    private String utruename;

    private String upassword;

    private String uidcard;

    private String uphone;

    private String umail;

    private String upic;

    private String usex;

    private Integer uage;

    private Integer udel;

    private Integer ucredit;

}