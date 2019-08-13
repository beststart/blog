package com.xd.pjj.myblog.mapper;

import com.xd.pjj.myblog.bean.CategoryArticle;

public interface CategoryArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryArticle record);

    int insertSelective(CategoryArticle record);

    CategoryArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryArticle record);

    int updateByPrimaryKey(CategoryArticle record);
}