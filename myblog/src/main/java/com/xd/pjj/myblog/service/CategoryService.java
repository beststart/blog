package com.xd.pjj.myblog.service;

import com.xd.pjj.myblog.bean.Category;
import com.xd.pjj.myblog.util.Result;

import java.util.List;

public interface CategoryService {
    Result update(Category category);
    Result getPage(int offset, int limit);
    Category getById(Integer id);
    Result delete(Integer id);
    List<Category> getAll();
    List<Category> getAllForFront();
}
