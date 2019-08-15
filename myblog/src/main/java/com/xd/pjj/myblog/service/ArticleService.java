package com.xd.pjj.myblog.service;

import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.bean.CategoryArticle;
import com.xd.pjj.myblog.mapper.CategoryMapper;
import com.xd.pjj.myblog.util.Result;

import java.util.List;

public interface ArticleService {
    Result update(Article article,Integer[] sel_category);
    Result getPage(int offset,int limit,Article article);

    List<CategoryArticle> getCategoryByAid(Integer aid);

    Article getById(Integer id);
}
