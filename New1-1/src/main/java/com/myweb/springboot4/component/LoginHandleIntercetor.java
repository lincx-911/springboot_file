package com.myweb.springboot4.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*
 * 进行登录检查
 */
public class LoginHandleIntercetor implements HandlerInterceptor {
	//private Logger logger = LoggerFactory.getLogger(LoginHandleIntercetor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object user =  request.getSession().getAttribute("loginUser");
		if(user== null) {
			//未登录，返回登录页面
			request.setAttribute("msg", "没有权限，请先登录");
			request.getRequestDispatcher("/login").forward(request, response);;
			//response.sendRedirect("/login");
			return false;
		}else {
			//已登录，放行请求
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
