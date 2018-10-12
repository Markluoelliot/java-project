package mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.cn.model.SysRole;

public interface RoleMapper {
	 @Results(id="roleResultMap", value={
	        @Result(property="id",column="id",id=true),
	        @Result(property="roleName",column="role_name"),
	        @Result(property="enabled",column="enabled"),
	        @Result(property="createBy",column="create_by"),
	        @Result(property="createTime",column="create_time")
	    })
	    @ResultMap("roleResultMap")
	    @Select("select * from sys_role")
	    List<SysRole> selectAll();      
	    
	 @Select({
		 "select id,role_name roleName,enabled,create_by createBy,create_time createTime",
		 "from sys_role",
		 "where id=#{id}"
	 })
	 SysRole selectById(Long id);
	 //不返回自增主键
	 @Insert({
		 "insert into sys_role(id,role_name,enabled,create_by,create_time)","values(#{id},#{roleName},#{enabled},#{createBy},",
		 "#{createTime,jdbcType=TIMESTAMP})"})
	 int insert(SysRole sysRole);
	 //返回自增主键
	 @Insert({
		 "insert into sys_role(id,role_name,enabled,create_by,create_time)","values(#{id},#{roleName},#{enabled},#{createBy},",
		 "#{createTime,jdbcType=TIMESTAMP})"})
	 @Options(useGeneratedKeys=true,keyProperty="id")
	 int insert2(SysRole sysRole);
	
}
