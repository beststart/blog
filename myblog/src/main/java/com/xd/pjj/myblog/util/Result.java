package com.xd.pjj.myblog.util;

public class Result {
    private Integer code;
    private String msg;
    private Boolean valid;

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
}
