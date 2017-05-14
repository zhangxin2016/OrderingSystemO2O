package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Collectionuser {
    private Integer collid;

    private Integer fid;

    private Integer stid;

    private Integer uid;

    private Date colldate;

    private Integer colldelete;

    private Food food;

    private Stores stores;
}