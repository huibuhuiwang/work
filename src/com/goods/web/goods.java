package com.goods.web;

import java.io.Serializable;
import java.util.Date;

public class goods {
    private int goodsno;
    private  String goodsname;
    private  float goodsprice;
    private  int goodsnumber;
    private int goodssales;
    private  String purchasedata;
    private  float supplierprice;

    public int getGoodsno(){
        return goodsno;
    }
    public void setGoodsno(int goodsno){
        this.goodsno = goodsno;
    }
    public String getGoodsname(){
        return goodsname;
    }
    public void setGoodsname(String goodsname){
        this.goodsname = goodsname;
    }
    public float getGoodsprice(){
        return goodsprice;
    }
    public void setGoodsprice(float goodsprice){
        this.goodsprice =goodsprice;
    }
    public int getGoodsnumber(){
        return goodsnumber;
    }
    public void setGoodsnumber(int goodsnumber) {
        this.goodsnumber = goodsnumber;
    }
    public int getGoodssales() {
        return goodssales;
    }
    public void setGoodssales(int goodssales) {
        this.goodssales = goodssales;
    }
    public String getPurchasedata() {
        return purchasedata;
    }
    public void setPurchasedata(String purchasedata) {
        this.purchasedata = purchasedata;
    }
    public float getSupplierprice() {
        return supplierprice;
    }
    public void setSupplierprice(float supplierprice) {
        this.supplierprice = supplierprice;
    }
}
