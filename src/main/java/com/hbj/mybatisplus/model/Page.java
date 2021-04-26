package com.hbj.mybatisplus.model;

import java.io.Serializable;

public abstract class Page implements Serializable {
    protected Integer page;
    protected Integer rows;

    public Integer getPage() {
        if (this.page == null || this.page <= 0) {
            return 1;
        }
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        if (this.rows == null || rows <= 0) {
            return 1;
        }
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
