package com.cn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.dao.PostDao;
import com.cn.model.Post;


@Service
public class PostService {
    @Autowired
    private PostDao postDao;
	

	
	public List<Post> showParents()  {
		// TODO Auto-generated method stub
		//PostDao postDao = new PostDaoImpl();
		return postDao.findByNullPid();
	
	}

	
	public boolean publish(Post post)  {
		// TODO Auto-generated method stub
		//PostDao postDao = new PostDaoImpl();
		return postDao.save(post);
	}

	
	public Post showInfo(Long postid)  {
		// TODO Auto-generated method stub
		//PostDao postDao = new PostDaoImpl();
		Post parent = postDao.getByPostPid(postid);
		List<Post> children = postDao.findByParentId(postid);
		parent.setChildren(children);
		return parent;
		//return postDao.getByPostPid(postid);
				
	}

	
	public void reply(Post post){
		// TODO Auto-generated method stub
		//PostDao postDao = new PostDaoImpl();
		postDao.saveZiTie(post);
	}

	
	public Post getInfo(Long postId)  {
		// TODO Auto-generated method stub
		//PostDao postDao = new PostDaoImpl();
		Post post = postDao.getByPostPid(postId);
	    return post;
	}

	
	public void edit(Post post) {
		// TODO Auto-generated method stub
		//PostDao pd = new PostDaoImpl();
		postDao.update(post);
	}

	
	public void del(Long postId) {
		// TODO Auto-generated method stub
		//PostDao pd = new PostDaoImpl();
		postDao.delete(postId);
	}
			
			
		
	

}
