package com.zx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private Integer adid;

    private String adcon;

    private String adtel;

    private String adname;

    private Integer uid;

    private Integer addelete;
}