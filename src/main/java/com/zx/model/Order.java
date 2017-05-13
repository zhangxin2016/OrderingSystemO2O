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
public class Order {
    private Integer oid;

    private Integer onum;

    private Integer otatal;

    private Integer uid;

    private Date odate;

    private Integer odelete;

    private UserBuy userBuy;

}