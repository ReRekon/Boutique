package com.example.entity;
//商品规格
public class Goods_specific {
    private  Integer gs_id;
    private  Integer t_id;
    //规格描述
    private  String gd_desc;
    //规格对应价格
    private  String t_price;

    public Integer getGs_id() {
        return gs_id;
    }

    public void setGs_id(Integer gs_id) {
        this.gs_id = gs_id;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getGd_desc() {
        return gd_desc;
    }

    public void setGd_desc(String gd_desc) {
        this.gd_desc = gd_desc;
    }

    public String getT_price() {
        return t_price;
    }

    public void setT_price(String t_price) {
        this.t_price = t_price;
    }
}
