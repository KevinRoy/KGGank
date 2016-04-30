package com.kevin.kggank.entity;

/**
 * 基本base result
 * Created by kevin on 16/4/18.
 */
public class BaseResultEntity<T> {

    protected boolean error;
    protected T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
