package com.xd.pjj.myblog.controller;

import com.xd.pjj.myblog.bean.User;
import com.xd.pjj.myblog.service.UserService;
import com.xd.pjj.myblog.util.MD5Util;
import com.xd.pjj.myblog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/admin/user")
@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(User user, HttpSession session){
        user.setPassword(MD5Util.MD5(user.getPassword()));
        user=userService.login(user);
        if(user==null){
            return new Result(0,"用户名或密码不正确！");
        }else{
            session.setAttribute("loginInfo",user);
            return new Result(1,"登录成功！");
        }
    }

    @RequestMapping("/logout")
    public Result logout(HttpSession session){
        session.removeAttribute("loginInfo");
        return new Result(1);
    }

    @RequestMapping("/getImg")
    public List<Result> getImg(HttpServletRequest request){
        /*获取项目地址*/
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + request.getContextPath()
                + "/";
        /*获取绝对地址*/
        String uploadPath=request.getServletContext().getRealPath("/upload");
        File file=new File(uploadPath);
        String[] fs=file.list();
        List<Result> list=new ArrayList<>();
        for(int i=0;i<fs.length;i++){
            list.add(new Result(i,basePath+"upload/"+fs[i]));
        }
        return list;
    }
}
