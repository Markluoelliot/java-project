package com.cn.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.PreparedStatement;

public class CRUD {
    @Test
    public void testQuery() {
    	Connection connection = JDBCUtils.getConnection();
    	String sql = "SELECT * FROM people ";
    	try {
    		PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement(sql);
    	     
    	    ResultSet rs = pstmt.executeQuery();
    	    while(rs.next()) {
    	    Long id = rs.getLong(1);
    	    String name = rs.getString(2);
    	    String birthday = rs.getString(3);
    	    System.out.println(id +" "+ name+" "+birthday);
    	    }
    	    JDBCUtils.release(rs,pstmt, connection);
    	    
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}
