package com.xd.pjj.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.pjj.myblog.bean.Comment;
import com.xd.pjj.myblog.mapper.CommentMapper;
import com.xd.pjj.myblog.service.CommentService;
import com.xd.pjj.myblog.util.MyUtil;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Result update(Comment comment) {
        if(comment.getId()==null){
            comment.setCreated(MyUtil.nowDate());
            return new Result(commentMapper.insertSelective(comment));
        }
        return new Result(commentMapper.updateByPrimaryKeySelective(comment));
    }

    @Override
    public Result getPage(Integer page, Integer limit, Comment comment) {
        PageHelper.startPage(page,limit);
        List<Comment> list=commentMapper.getAll(comment);
        PageInfo<Comment> pageInfo=new PageInfo<>(list);
        return new Result(pageInfo.getTotal(),list,pageInfo);
    }

    @Override
    public Result delete(Integer id) {
        return new Result(commentMapper.deleteByPrimaryKey(id));
    }
}
