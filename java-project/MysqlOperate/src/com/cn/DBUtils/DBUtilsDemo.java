package com.cn.DBUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DBUtilsDemo {
	public static void main(String[] args) {
	    QueryRunner qr = new QueryRunner(DataPool.getDataSource());
		String sql = "SELECT * FROM people";
		
		try {
		 List<People> plist = qr.query(sql, new BeanListHandler<People>(People.class));
		 System.out.println(plist.get(0).getBirthday());
		}catch(SQLException e) {
			e.printStackTrace();
		}
}
}
