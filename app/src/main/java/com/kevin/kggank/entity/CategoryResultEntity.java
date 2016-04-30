package com.kevin.kggank.entity;

import java.util.List;

/**
 * 有类别的 result
 * Created by kevin on 16/4/18.
 */
public class CategoryResultEntity<T> extends BaseResultEntity<T> {

    private List<String> categories;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
