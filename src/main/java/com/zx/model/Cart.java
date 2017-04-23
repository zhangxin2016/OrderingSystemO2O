package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {
    private Integer cid;

    private Integer num;

    private Integer ctotal;

    private Integer fid;

    private Integer uid;

    private Integer cdelete;

    private Food foods;

    private UserBuy user;
}