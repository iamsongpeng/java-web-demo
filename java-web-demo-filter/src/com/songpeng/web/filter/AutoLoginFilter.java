package com.songpeng.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.songpeng.domain.User;
import com.songpeng.service.UserService;
import com.songpeng.service.impl.UserServiceImpl;

public class AutoLoginFilter implements Filter {

	public AutoLoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpSession session = httpServletRequest.getSession();
		if(session.getAttribute("existUser") != null) {
			// 1 如果用户已经登录, 直接放行
			chain.doFilter(httpServletRequest, response);
		} else {
			// 2 如果用户没有登录
			// 2.1 获取自动登录的 cookie
			Cookie[] cookies = httpServletRequest.getCookies();
			Cookie cookie = findCookieByName(cookies, "autoLogin");
			// 2.2判断 cookie 的 autoLogin 是否存在
			if(cookie != null) {
				// 2.2.1 如果存在
				// 2.2.1.1 从 cookie 中取出用户名和密码
				String username = cookie.getValue().split("#songpeng#")[0];
				String password = cookie.getValue().split("#songpeng#")[1];
				// 2.2.1.2 根据用户名和密码查询用户信息
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				UserService userService = new UserServiceImpl();
				User existUser = userService.login(user);
				// 2.2.1.3 判断用户信息的合法性
				if(existUser != null) {
					// 2.2.1.3.1 如果用户信息合法, 将用户信息保存到 session 中
					httpServletRequest.getSession().setAttribute("existUser", existUser);
				}
			}
			// 2.3 放行
			chain.doFilter(request, response);
		}
	}

	private Cookie findCookieByName(Cookie[] cookies, String str) {
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if(str.equals(cookies[i].getName())) {
					return cookies[i];
				}
			}
		}
		return null;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
