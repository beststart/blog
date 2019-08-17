package com.xd.pjj.myblog.controller.front;

import com.xd.pjj.myblog.bean.Comment;
import com.xd.pjj.myblog.service.CommentService;
import com.xd.pjj.myblog.service.PostService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/getPost")
    public Map<String,Object> getPost(@RequestParam(defaultValue = "0") Integer aid){
        return postService.getPostInfo(aid);
    }

    @RequestMapping("/getCommentList")
    public Result getCommentList(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer limit,@RequestParam(defaultValue = "0") Integer aid){
        Comment comment=new Comment();
        comment.setAid(aid);
        comment.setStatus(1);
        return commentService.getPage(page,limit,comment);
    }

    @RequestMapping("/addHits")
    public void addHits(@RequestParam(defaultValue = "0") Integer aid){
        postService.addHits(aid);
    }

    @RequestMapping("/addComment")
    public Result addComment(Comment comment){
        return commentService.update(comment);
    }
}
