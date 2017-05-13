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
public class Detailorder {
    private Integer doid;

    private Integer oid;

    private Integer fid;

    private Integer donum;

    private Integer dopri;

    private Date dodate;

    private Integer dostatus;

    private Integer adid;

    private Integer dodelete;

    private String domessage;

    private Order order;

    private Food food;

    private Address address;
}