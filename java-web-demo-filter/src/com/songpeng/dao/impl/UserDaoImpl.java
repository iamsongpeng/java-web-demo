package com.songpeng.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.songpeng.dao.UserDao;
import com.songpeng.domain.User;
import com.songpeng.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByUsernameAndPWD(User user) {
		// 创建对象
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		
		try {
			User existUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
			return existUser;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("用户查询错误!");
		}
	}

}
