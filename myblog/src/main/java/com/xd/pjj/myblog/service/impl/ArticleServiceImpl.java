package com.xd.pjj.myblog.service.impl;

import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.mapper.ArticleMapper;
import com.xd.pjj.myblog.service.ArticleService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result update(Article article, Integer[] sel_category) {
        int result;
        if(article.getId()==null){
            result=articleMapper.insertSelective(article);
            if(result>0){

            }else{
                throw new Error("添加文章内容失败！");
            }
        }
        return null;
    }
}
