package com.xd.pjj.myblog.service;

import com.xd.pjj.myblog.bean.Comment;
import com.xd.pjj.myblog.util.Result;

public interface CommentService {
    Result update(Comment comment);
    Result getPage(Integer page,Integer limit,Comment comment);
    Result delete(Integer id);
    Comment getById(Integer id);
}
