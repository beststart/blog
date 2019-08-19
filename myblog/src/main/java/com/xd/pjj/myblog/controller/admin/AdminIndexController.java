package com.xd.pjj.myblog.controller.admin;

import com.xd.pjj.myblog.service.AdminIndexService;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
@RequestMapping("/admin")
public class AdminIndexController {
    @Autowired
    private AdminIndexService adminIndexService;

    @RequestMapping("/getIndexCount")
    public Result getIndexCount(HttpServletRequest request) {
        String imgPath = request.getServletContext().getRealPath("/upload");
        return adminIndexService.getIndexInfo(imgPath);
    }

    @RequestMapping("/getInfoList")
    public Result getInfoList(){
        return adminIndexService.getInfoList();
    }
}
