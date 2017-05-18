package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stores {
    private Integer stid;

    private String staddress;

    private String stname;

    private String stdesc;

    private Integer stypeid;

    private Integer stdelete;

    private Integer usid;

    private String uscoll;

    private Storestype storestype;

    private UserSell userSell;

}