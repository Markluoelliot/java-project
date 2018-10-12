package com.cn.test;

import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cn.model.Country;
import com.cn.model.SysRole;
import com.cn.model.SysUser;

import mybatis.mapper.UserMapper;

public class CountryMapperTest extends BaseMapperTest {
	private SqlSession sqlSession  = getSqlSession();
	
    
    public void testCountrySelectAll() {
    	//SqlSession sqlSession  = getSqlSession();
    	try {
    		List<Country> countryList = sqlSession.selectList("mybatis.mapper.CountryMapper.selectAll");
    		printCountryList(countryList);
    	}finally {
    		sqlSession.close();
    	}
    }
	private void printCountryList(List<Country> countryList) {
		// TODO Auto-generated method stub
		for(Country country:countryList) {
			System.out.printf("%-4d%-4s%4s\n",
			country.getId(),country.getCountryname(),country.getCountrycode());
		}
	}
	
	public void testSelectById() {
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1L);
			Assert.assertNotNull(user);
			Assert.assertEquals("admin", user.getUserName());
			
		}finally {
			sqlSession.close();
		}
	}
	
	public void testSelectAll() {
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysUser> list = userMapper.selectAll();
			Assert.assertNotNull(list);
			Assert.assertTrue(list.size()>0);
		}finally {
			sqlSession.close();
		}
	}
	
	public void testSelectRoleByUserId() {
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
			Assert.assertNotNull(roleList);
			Assert.assertTrue(roleList.size()>0);
			
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testInsert() {
		try {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SysUser user = new SysUser();
		user.setUserName("test1");
		user.setUserPassword("123456");
		user.setUserEmail("test@mybatis");
		user.setUserInfo("test info");
		user.setHeadImg(new byte[] {1,2,3});
		user.setCreateTime(new Date());
		int result = userMapper.insert3(user);
		Assert.assertEquals(1, result);
		Assert.assertNull(user.getId());
		}finally {
			//不影响其他测试，这里选择回滚
			//由于默认的sqlSessionFactory.openSession()不会自动提交
			sqlSession.rollback();
			//关闭sqlsession
			sqlSession.close();
		}
	}
	@Test
	public void testUpdate() {
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user =userMapper.selectById(1L);
			Assert.assertEquals("admin", user.getUserName());
			
			user.setUserName("admin_test");
			user.setUserEmail("test@mybatis");
		    int result = userMapper.updateById(user);
		    Assert.assertEquals(1, result);
		    user = userMapper.selectById(1L);
		    Assert.assertEquals("admin_test", user.getUserName());
		    
		}finally {
			sqlSession.rollback();
			sqlSession.close();
		}
		
	}
	
}
