package com.kevin.kggank.entity;

import java.util.List;

/**
 * 有类别的 result
 * Created by kevin on 16/4/18.
 */
public class CategoryResultEntity<T> extends BaseResultEntity<T> {

    private List<String> category;

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
}
