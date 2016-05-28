package com.kevin.kggank.entity;

/**
 * Created by kevin on 16/5/26.
 */

public class GanhuoTypeEntity {

    private String type;
    private int bgColor;
    private int imgRes;

    public GanhuoTypeEntity(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
