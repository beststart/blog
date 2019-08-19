package com.xd.pjj.myblog.util;

import com.github.pagehelper.PageInfo;
import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.bean.Comment;

import java.util.List;

public class Result {
    private Integer code;
    private String msg;
    private Boolean valid;
    private Long total;
    private List rows;
    private PageInfo pageInfo;


    private Integer articleCount;
    private Integer commentCount;
    private Integer imgCount;

    private List<Article> articleList;
    private List<Comment> commentList;

    public Result() {
    }

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Boolean valid) {
        this.valid = valid;
    }

    public Result(List<Article> articleList, List<Comment> commentList) {
        this.articleList = articleList;
        this.commentList = commentList;
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

    public Result(Integer articleCount, Integer commentCount, Integer imgCount) {
        this.articleCount = articleCount;
        this.commentCount = commentCount;
        this.imgCount = imgCount;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getImgCount() {
        return imgCount;
    }

    public void setImgCount(Integer imgCount) {
        this.imgCount = imgCount;
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

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
