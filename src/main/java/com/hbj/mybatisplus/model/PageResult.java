package com.hbj.mybatisplus.model;


import java.io.Serializable;

public class PageResult<T> implements Serializable {
    private Long total;
    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public PageResult(Long total, T result) {
        this.total = total;
        this.result = result;
    }
}