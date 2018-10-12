package com.cn.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class JDBCUtils {
    //注册驱动
	public static final String DRIVER_CLASS;
	public static final String DRIVER_URL;
	public static final String USERNAME;
	public static final String PASSWORD;
	
	static {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/jdbc.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DRIVER_CLASS = prop.getProperty("jdbc.driver.class");
		DRIVER_URL = prop.getProperty("jdbc.url");
		USERNAME = prop.getProperty("jdbc.username");
		PASSWORD = prop.getProperty("jdbc.password");
	    try {
	    	Class.forName(DRIVER_CLASS);
	    }catch(ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	}
	//获得链接 
	public static Connection getConnection() {
		Connection connection = null;
		try {
		connection = DriverManager.getConnection(DRIVER_URL, USERNAME, PASSWORD);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	//释放资源
	public static void release(Statement stmt,Connection conn){
		
			if(stmt!=null) {
				try {
				stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
	}
		public static void release(ResultSet rs,Statement stmt,Connection conn) {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				rs =null;
			}
			if(stmt!=null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}

