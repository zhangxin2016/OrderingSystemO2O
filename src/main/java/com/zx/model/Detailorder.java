package com.zx.model;

import java.util.Date;

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

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getDonum() {
        return donum;
    }

    public void setDonum(Integer donum) {
        this.donum = donum;
    }

    public Integer getDopri() {
        return dopri;
    }

    public void setDopri(Integer dopri) {
        this.dopri = dopri;
    }

    public Date getDodate() {
        return dodate;
    }

    public void setDodate(Date dodate) {
        this.dodate = dodate;
    }

    public Integer getDostatus() {
        return dostatus;
    }

    public void setDostatus(Integer dostatus) {
        this.dostatus = dostatus;
    }

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public Integer getDodelete() {
        return dodelete;
    }

    public void setDodelete(Integer dodelete) {
        this.dodelete = dodelete;
    }
}