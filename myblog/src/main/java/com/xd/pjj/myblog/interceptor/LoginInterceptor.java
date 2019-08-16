package com.xd.pjj.myblog.interceptor;

import com.alibaba.fastjson.JSON;
import com.xd.pjj.myblog.bean.User;
import com.xd.pjj.myblog.util.Result;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("loginInfo");
        if(user==null){
            /*ajax请求需要返回json数据，其他请求跳转页面*/
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with")
                    .equalsIgnoreCase("XMLHttpRequest")) { //如果是ajax请求响应头会有x-requested-with
                response.setContentType("application/html;charset=utf-8");
                response.setCharacterEncoding("utf-8");
                Map<String,Integer> map=new HashMap<>();
                map.put("code",403);
                response.getWriter().print(JSON.toJSON(map));
                return false;
            }else{
                response.sendRedirect(request.getContextPath() + "/error/nopass.html");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
