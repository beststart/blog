package com.xd.pjj.myblog.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/";
		request.setAttribute("basePath", basePath);
        filterChain.doFilter(request, response);
//		// 不用过滤的url
//		String[] notFilter = new String[] {"/TechOnline/","/TechOnline/login/tologin.aspx","/TechOnline/login/doLogin.aspx","/TechOnline/login/httpLogin.aspx","/TechOnline/log/savelog.aspx"};
//		// 请求的URL
//		String url = request.getRequestURI();
//		if (url.indexOf("/TechOnline") != -1) {
//			boolean doFilter = true;
//			for (String s : notFilter) {
//				if (s.equals(url)) {
//					doFilter = false;
//					break;
//				}
//			}
//			if (doFilter) {
//				Object obj = request.getSession().getAttribute("userLogin");
//				if (null == obj) {
//					request.setCharacterEncoding("utf-8");
//					response.setCharacterEncoding("utf-8");
//					response.setContentType("text/html;charset=UTF-8");
//					PrintWriter out = response.getWriter();
//					StringBuilder builder = new StringBuilder();
//					builder.append("<script type=\"text/javascript\">");
//					builder.append("alert('网页过期，请重新登录！');");
//					builder.append("window.top.location.href='");
//					builder.append(basePath);
//					builder.append("';");
//					builder.append("</script>");
//					out.print(builder.toString());
//				} else {
//					filterChain.doFilter(request, response);
//				}
//			} else {
//				filterChain.doFilter(request, response);
//			}
//		} else {
//			filterChain.doFilter(request, response);
//		}
	}
}
