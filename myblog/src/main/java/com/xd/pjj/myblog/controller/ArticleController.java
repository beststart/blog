package com.xd.pjj.myblog.controller;

import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.bean.CategoryArticle;
import com.xd.pjj.myblog.service.ArticleService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/article")
@ResponseBody
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/update")
    public Result update(Article article,Integer[] sel_category){
        return articleService.update(article,sel_category);
    }

    @RequestMapping("/getPage")
    public Result getPage(Integer offset,Integer limit,Article article){
        return articleService.getPage(offset,limit,article);
    }

    @RequestMapping("/getCategoryByAid")
    public List<CategoryArticle> getCategoryByAid(Integer aid){
        return articleService.getCategoryByAid(aid);
    }

    @RequestMapping("/getById")
    public Article getById(Integer id){
        return articleService.getById(id);
    }

}
