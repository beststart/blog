package com.xd.pjj.myblog.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class Result {
    private Integer code;
    private String msg;
    private Boolean valid;
    private Long total;
    private List rows;
    private PageInfo pageInfo;

    public Result() {
    }

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Boolean valid) {
        this.valid = valid;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Result(Long total, List rows, PageInfo pageInfo) {
        this.total = total;
        this.rows = rows;
        this.pageInfo = pageInfo;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
