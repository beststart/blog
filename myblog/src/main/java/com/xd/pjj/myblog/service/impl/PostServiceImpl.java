package com.xd.pjj.myblog.service.impl;

import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.bean.CategoryArticle;
import com.xd.pjj.myblog.mapper.ArticleMapper;
import com.xd.pjj.myblog.mapper.CategoryArticleMapper;
import com.xd.pjj.myblog.mapper.CommentMapper;
import com.xd.pjj.myblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryArticleMapper categoryArticleMapper;

    @Override
    public Map<String,Object> getPostInfo(Integer aid) {
        //1.获取文章信息
        Article article=articleMapper.selectByPrimaryKey(aid);
        //2.获取文章分类
        List<CategoryArticle> caList=categoryArticleMapper.getByAid(aid);
        Map<String,Object> map=new HashMap<>();
        map.put("article",article);
        map.put("caList",caList);
        return map;
    }

    @Override
    public void addHits(Integer aid) {
        articleMapper.addHits(aid);
    }

}
