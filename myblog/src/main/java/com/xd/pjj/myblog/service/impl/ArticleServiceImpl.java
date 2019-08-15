package com.xd.pjj.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xd.pjj.myblog.bean.Article;
import com.xd.pjj.myblog.bean.CategoryArticle;
import com.xd.pjj.myblog.mapper.ArticleMapper;
import com.xd.pjj.myblog.mapper.CategoryArticleMapper;
import com.xd.pjj.myblog.mapper.CategoryMapper;
import com.xd.pjj.myblog.service.ArticleService;
import com.xd.pjj.myblog.util.MyUtil;
import com.xd.pjj.myblog.util.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryArticleMapper categoryArticleMapper;

    @Override
    public Result update(Article article, Integer[] sel_category) {
        int result;
        List<CategoryArticle> caList;
        if(article.getId()==null){
            article.setCreated(MyUtil.nowDate());
            result=articleMapper.insertSelective(article);
            if(result>0){
                caList=formateList(article.getId(),sel_category);
                result=categoryArticleMapper.batchInsert(caList);
                if(result!=caList.size()){
                    throw new Error("添加分类失败！");
                }
            }else{
                throw new Error("添加文章内容失败！");
            }
        }else{
            article.setUpdated(MyUtil.nowDate());
            result=articleMapper.updateByPrimaryKeySelective(article);
            if(result>0){
                int count=categoryArticleMapper.getByAid(article.getId()).size();
                result=categoryArticleMapper.deleteByAid(article.getId());
                if(result==count){
                    caList=formateList(article.getId(),sel_category);
                    result=categoryArticleMapper.batchInsert(caList);
                    if(result!=caList.size()){
                        throw new Error("更新分类失败！");
                    }
                }else{
                    throw new Error("更新(删除)分类失败！");
                }

            }
        }
        return new Result(result);
    }

    @Override
    public Result getPage(int offset, int limit, Article article) {
        if(StringUtils.isNotEmpty(article.getCreated())){
            String[] time=article.getCreated().split(" - ");
            article.setCreated(time[0]);
            article.setUpdated(time[1]);
        }
        int page=offset/limit+1;
        PageHelper.startPage(page,limit);
        List<Article> list=articleMapper.getAll(article);
        PageInfo<Article> pageInfo=new PageInfo<>(list);
        return new Result(pageInfo.getTotal(),list);
    }

    @Override
    public List<CategoryArticle> getCategoryByAid(Integer aid) {
        return categoryArticleMapper.getByAid(aid);
    }

    @Override
    public Article getById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    private List<CategoryArticle> formateList(Integer aid,Integer[] sel_category){
        List<CategoryArticle> caList=new ArrayList<>();
        for(Integer cid:sel_category){
            CategoryArticle ca=new CategoryArticle();
            ca.setCid(cid);
            ca.setAid(aid);
            caList.add(ca);
        }
        return caList;
    }
}
