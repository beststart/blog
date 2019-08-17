package com.xd.pjj.myblog.controller.front;

import com.xd.pjj.myblog.bean.Category;
import com.xd.pjj.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/archives")
public class ArchivesController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/getCategoryList")
    public List<Category> getCategoryList(){
        return categoryService.getAllForFront();
    }

}
