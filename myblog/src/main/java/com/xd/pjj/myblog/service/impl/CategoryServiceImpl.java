package com.xd.pjj.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.pjj.myblog.bean.Category;
import com.xd.pjj.myblog.mapper.CategoryMapper;
import com.xd.pjj.myblog.service.CategoryService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public Result update(Category category) {
        int result;
        if(category.getId()==null){
            result=categoryMapper.insertSelective(category);
        }else{
            result=categoryMapper.updateByPrimaryKeySelective(category);
        }
        return new Result(result);
    }

    @Override
    public Result getPage(int offset, int limit) {
        int page=offset/limit+1;
        PageHelper.startPage(page,limit);
        List<Category> list=categoryMapper.getAll();
        PageInfo<Category> pageInfo=new PageInfo<>(list);
        return new Result(pageInfo.getTotal(),list);
    }

    @Override
    public Category getById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result delete(Integer id) {
        return new Result(categoryMapper.deleteByPrimaryKey(id));
    }

    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll();
    }
}
