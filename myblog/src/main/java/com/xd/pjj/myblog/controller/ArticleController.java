package com.xd.pjj.myblog.controller;

import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.service.ArticleService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
