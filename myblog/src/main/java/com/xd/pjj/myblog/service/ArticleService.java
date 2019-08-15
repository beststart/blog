package com.xd.pjj.myblog.service;

import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.util.Result;

public interface ArticleService {
    Result update(Article article,Integer[] sel_category);
}
