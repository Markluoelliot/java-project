package com.cn.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataPool {
    private static final ComboPooledDataSource dataSource = new ComboPooledDataSource();
	private static Connection getConnection() {
    	Connection conn = null;
    	try {
    		conn = dataSource.getConnection();
    	}catch(SQLException e) {
    		System.out.println("连接失败");
    	}
    	return conn;
    }
	public static DataSource getDataSource() {
		return dataSource;
	}
}
