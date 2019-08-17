package com.xd.pjj.myblog.controller.front;

import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.service.ArticleService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/frontIndex")
public class FrontIndexController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/getArticleList")
    public Result getPage(@RequestParam(defaultValue = "1",required = false) Integer page,@RequestParam(defaultValue = "5",required = false) Integer limit){
        Article article=new Article();
        article.setStatus(1);
        return articleService.getPage(page,limit,article);
    }
}
