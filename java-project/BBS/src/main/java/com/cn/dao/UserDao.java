package com.cn.dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.model.User;
@Mapper
public interface UserDao{
    @Insert({
    	"insert into postuser VALUES(NULL,#{account},#{password},#{nickname},#{birthday})"
    })
    boolean save(User user);
	
    @Select({
    	"select * from postuser WHERE account = #{account} AND password = #{password}"
    })
    User getByAccountAndPassword(User user);
	

}
