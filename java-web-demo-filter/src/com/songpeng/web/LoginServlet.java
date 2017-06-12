package com.songpeng.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.songpeng.domain.User;
import com.songpeng.service.UserService;
import com.songpeng.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1 获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 2 根据用户名和密码查询用户信息
		// 2.1 封装 JavaBean
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// 2.2 将 JavaBean 传给业务层
		UserService userService = new UserServiceImpl();
		User existUser = userService.login(user);
		// 3 判断响应
		// 3.1 如果用户信息不存在, 表示登录失败
		if(existUser == null) {
			// 3.1.1 将错误信息保存到 request 中
			request.setAttribute("msg", "用户名或密码错误");
			// 3.1.2 使用请求转发, 跳转到登录页面
			request.getRequestDispatcher("/demo02/login.jsp").forward(request, response);;
			return;
		} else {
			// 3.2 如果用户信息存在, 表示登录成功
			// 3.2.1 将用户信息保存到 session 中
			request.getSession().setAttribute("existUser", existUser);
			// 3.2.2 判断用户是否选择自动登录
			String isChecked = request.getParameter("isChecked");
			if(isChecked != null) {
				if("on".equals(isChecked)) {
					// 3.2.2.1 如果选择自动登录
					// 3.2.2.1.1 创建 Cookie, 保存用户名和密码, 发送给浏览器
					Cookie cookie = new Cookie("autoLogin", existUser.getUsername() + "#songpeng#" + existUser.getPassword());
					cookie.setPath("/");
					cookie.setMaxAge(60 * 60 * 24 * 30);
					response.addCookie(cookie);
				} else {
					// 3.2.2.2 如果用户没有选择自动登录
					// 3.2.2.2.1 通知浏览器删除自动登录的 Cookie
					Cookie cookie = new Cookie("autoLogin", "");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			// 3.2.3 使用重定向跳转到首页
			response.sendRedirect(request.getContextPath() + "/demo02/index.jsp");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}