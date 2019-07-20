package com.example.entity;

import java.math.BigDecimal;

public class Things {
    private Integer t_id;
    private  String t_name;
    //商品描述
    private  String t_dis;
    //收藏次数
    private BigDecimal t_coll_count;
    //库存量
    private BigDecimal inventory;

    private  String t_img;
    //热度
    private  Integer heat;
    //评分
    private  Float mark;
    //已下架
    private  Integer state;
 /*   //折扣
    private Float discount;*/

   /* public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }*/

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_dis() {
        return t_dis;
    }

    public void setT_dis(String t_dis) {
        this.t_dis = t_dis;
    }

    public BigDecimal getT_coll_count() {
        return t_coll_count;
    }

    public void setT_coll_count(BigDecimal t_coll_count) {
        this.t_coll_count = t_coll_count;
    }

    public BigDecimal getInventory() {
        return inventory;
    }

    public void setInventory(BigDecimal inventory) {
        this.inventory = inventory;
    }

    public String getT_img() {
        return t_img;
    }

    public void setT_img(String t_img) {
        this.t_img = t_img;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Things{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_dis='" + t_dis + '\'' +
                ", t_coll_count=" + t_coll_count +
                ", inventory=" + inventory +
                ", t_img='" + t_img + '\'' +
                ", heat=" + heat +
                ", mark=" + mark +
                ", state=" + state +
                '}';
    }
}
