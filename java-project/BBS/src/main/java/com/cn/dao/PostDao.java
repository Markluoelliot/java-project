package com.cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.model.Post;
@Mapper
public interface PostDao {
    @Select({
    	"SELECT * FROM post WHERE parentId is NULL"
    })
	List<Post> findByNullPid();
    
    @Insert({
    	"INSERT INTO post (title,content,authorId) VALUES(#{title},#{content},#{authorId})"
    })
	boolean save(Post post);
   
    @Select({
    	"SELECT * FROM post WHERE id = #{id}"
    })
	Post getByPostPid(Long postid);

	@Select({
		"SELECT * FROM post WHERE parentId = #{parentId}"
	})

	List<Post> findByParentId(Long postid);
    
	@Insert({
		"INSERT INTO post (title,content,authorId,parentId) VALUES(null,#{content},#{authorId},#{parentId})"
	})
	void saveZiTie(Post post);

	@Update({
		"UPDATE post SET title=#{title},content = #{content} WHERE id = #{id}"
	})
	void update(Post post) ;

	@Delete({
		"DELETE FROM post WHERE id = #{id}"
	})
	void delete(Long postId);

	
	

}
