package com.songpeng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.songpeng.domain.User;
import com.songpeng.utils.JDBCUtils;

// 操作用户表
public class UserDao {
	/*
	 * 根据用户名和密码查询用户信息
	 */
	public User findByUsernameAndPassword(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			// 获得连接
			conn = JDBCUtils.getConnection();
			// 获得执行sql的对象
			String sql = "select * from user where username=? and password=?";
			stmt = conn.prepareStatement(sql);
			// 设置参数
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			// 执行 sql 获得结果
			rs = stmt.executeQuery();
			// 处理结果
			if (rs.next()) {
				// 查到了 将用户信息封装到 JavaBean 中
				User existUser = new User();
				existUser.setId(rs.getInt("id"));
				existUser.setUsername(rs.getString("username"));
				existUser.setPassword(rs.getString("password"));
				existUser.setNickname(rs.getString("nickname"));

				return existUser;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(conn, stmt, rs);
		}

		return null;
	}
	
	// 测试
	public static void main(String[] args) {
		User user = new User();
		user.setUsername("宋鹏");
		user.setPassword("123");

		UserDao dao = new UserDao();
		User existUser = dao.findByUsernameAndPassword(user);
		System.out.println(existUser);
	}
}
