package com.zx.model;

import java.util.Date;

public class Order {
    private Integer oid;

    private Integer onum;

    private Integer otatal;

    private Integer uid;

    private Date odate;

    private Integer odelete;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }

    public Integer getOtatal() {
        return otatal;
    }

    public void setOtatal(Integer otatal) {
        this.otatal = otatal;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Integer getOdelete() {
        return odelete;
    }

    public void setOdelete(Integer odelete) {
        this.odelete = odelete;
    }
}