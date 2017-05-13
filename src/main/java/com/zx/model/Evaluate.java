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
public class Evaluate {
    private Integer eid;

    private Integer doid;

    private String ebuycontent;

    private String esellcontent;

    private Date ebuydate;

    private Date eselldate;

    private Integer edelete;

    private Detailorder detailorder;
}