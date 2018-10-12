package com.cn.test;

import java.util.List;

import javax.management.relation.Role;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cn.model.Country;
import com.cn.model.SysRole;

import junit.framework.Assert;
import mybatis.mapper.RoleMapper;

public class RoleMapperTest extends BaseMapperTest {
private  SqlSession sqlSession  = getSqlSession();
	
    
   
	
	public void testSelectById() {
    	try {
    		RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
    		SysRole role =  rm.selectById(1L);
    		Assert.assertNotNull(role);
    		Assert.assertEquals("管理员", role.getRoleName());
    		
    	}finally {
    	sqlSession.close();
    	}
    	
    }
	@Test
	public void testSelectAll() {
		try {
			RoleMapper rm = sqlSession.getMapper(RoleMapper.class);
			List<SysRole>rolelist = rm.selectAll();
			//Assert.assertNotNull(rolelist);
			//Assert.assertTrue(rolelist.size()>0);
    		//Assert.assertNotNull("管理员", rolelist.get(0).getRoleName());
		}finally {
			sqlSession.close();
		}
	}
}
