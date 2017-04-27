package com.zx.model;

public class Address {
    private Integer adid;

    private String adcon;

    private String adtel;

    private String adname;

    private Integer uid;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAdcon() {
        return adcon;
    }

    public void setAdcon(String adcon) {
        this.adcon = adcon == null ? null : adcon.trim();
    }

    public String getAdtel() {
        return adtel;
    }

    public void setAdtel(String adtel) {
        this.adtel = adtel == null ? null : adtel.trim();
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname == null ? null : adname.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}