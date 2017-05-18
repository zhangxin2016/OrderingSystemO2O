package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Food {
    private Integer fid;

    private String fname;

    private Integer stid;

    private Integer fprice;

    private Integer fcollection;

    private Integer fsalesvolume;

    private Integer fstatus;

    private String fpic;

    private Integer fdelete;

    private Stores stores;

}