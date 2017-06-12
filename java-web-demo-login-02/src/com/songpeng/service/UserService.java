package com.songpeng.service;

import com.songpeng.dao.UserDao;
import com.songpeng.domain.User;

// 用户业务类
public class UserService {
	// 处理登录业务, 返回用户信息
	public User login(User user) {
		// 调用 dao 查询用户信息
		UserDao userDao = new UserDao();
		return userDao.findByUsernameAndPassword(user);
	}
	
	// 测试
	public static void main(String[] args) {
		User user = new User();
		user.setUsername("宋鹏");
		user.setPassword("123");

		UserService service = new UserService();
		User existUser = service.login(user);
		System.out.println(existUser);
	}
}
