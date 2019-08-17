package com.xd.pjj.myblog.service;

import com.xd.pjj.myblog.bean.Comment;
import com.xd.pjj.myblog.util.Result;

import java.util.Map;

public interface PostService {
    Map<String,Object> getPostInfo(Integer aid);
    void addHits(Integer aid);

}
