package com.songpeng.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	// 创建 c3p0 的连接池
	static ComboPooledDataSource cpds = new ComboPooledDataSource();

	// 方法: 获取连接池
	public static DataSource getDataSource() {
		return cpds;
	}

	// 方法: 获得连接
	public static Connection getConnection() throws SQLException {
		// 获得连接
		return cpds.getConnection();
	}

	// 方法: 释放资源
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs = null;

		release(conn, stmt);
	}

	public static void release(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stmt = null;
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
}
