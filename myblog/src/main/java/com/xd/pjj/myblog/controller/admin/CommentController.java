package com.xd.pjj.myblog.controller.admin;

import com.xd.pjj.myblog.bean.Comment;
import com.xd.pjj.myblog.service.CommentService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/admin/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/getPage")
    public Result getPage(int offset, int limit, Comment comment){
        int page=offset/limit+1;
        return commentService.getPage(page,limit,comment);
    }

    @RequestMapping("/getById")
    public Comment getById(Integer id){
        return commentService.getById(id);
    }

    @RequestMapping("/update")
    public Result update(Comment comment){
        return commentService.update(comment);
    }

    @RequestMapping("/delete")
    public Result delete(Integer id){
        return commentService.delete(id);
    }
}
