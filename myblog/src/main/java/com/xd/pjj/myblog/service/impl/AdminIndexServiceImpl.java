package com.xd.pjj.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.bean.Comment;
import com.xd.pjj.myblog.mapper.ArticleMapper;
import com.xd.pjj.myblog.mapper.CommentMapper;
import com.xd.pjj.myblog.service.AdminIndexService;
import com.xd.pjj.myblog.service.ImageService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminIndexServiceImpl implements AdminIndexService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ImageService imageService;
    @Override
    public Result getIndexInfo(String imgPath) {
        return new Result(articleMapper.getAll(new Article()).size(),commentMapper.getAll(new Comment()).size(),imageService.getImgList(imgPath).size());
    }

    @Override
    public Result getInfoList() {
        PageHelper.startPage(1,5);
        List<Article> articleList=articleMapper.getAll(new Article());
        PageHelper.startPage(1,3);
        List<Comment> commentList=commentMapper.getAll(new Comment());
        return new Result(articleList,commentList);
    }


}
