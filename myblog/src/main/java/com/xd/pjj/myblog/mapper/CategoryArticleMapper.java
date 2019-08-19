package com.xd.pjj.myblog.mapper;

import com.xd.pjj.myblog.bean.CategoryArticle;

import java.util.List;

public interface CategoryArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryArticle record);

    int insertSelective(CategoryArticle record);

    CategoryArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryArticle record);

    int updateByPrimaryKey(CategoryArticle record);

    int batchInsert(List<CategoryArticle> list);

    int batchDelete(Integer[] ids);

    int deleteByAid(int aid);

    List<CategoryArticle> getByAid(int aid);

    List<CategoryArticle> getByCid(int cid);
}