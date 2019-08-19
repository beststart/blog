package com.xd.pjj.myblog.controller.admin;

import com.xd.pjj.myblog.bean.Category;
import com.xd.pjj.myblog.bean.CategoryArticle;
import com.xd.pjj.myblog.service.CategoryService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
@ResponseBody
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/update")
    public Result update(Category category){
        return categoryService.update(category);
    }

    @RequestMapping("/getPage")
    public Result getPage(Integer offset,Integer limit){
        return categoryService.getPage(offset,limit);
    }

    @RequestMapping("/getById")
    public Category getById(Integer id){
        return categoryService.getById(id);
    }

    @RequestMapping("delete")
    public Result delete(Integer id){
        return categoryService.delete(id);
    }

    @RequestMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @RequestMapping("/getCategoryByCid")
    public List<CategoryArticle> getCategoryByCid(Integer cid){
        return categoryService.getCategoryByCid(cid);
    }

}
