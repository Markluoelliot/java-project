package com.cn.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.model.Post;
import com.cn.model.User;
import com.cn.service.PostService;


@Controller
public class PostServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  @Autowired
  private PostService postService;
	

	
    @RequestMapping(value="/doDel/{id}")
	public String doDel(@PathVariable("id") Long postId){
		// TODO Auto-generated method stub
		
		postService.del(postId);
	    return "redirect:/doList";
    }
    @RequestMapping(value="/doEdit/{id}")
	public String doEdit(Model model,@PathVariable(value="id") Long postId,
			           @RequestParam("content") String content,
			           @RequestParam("title") String title) {
		Post post = new Post(postId,title,content);
		postService.edit(post);
		model.addAttribute("post", post);
		return "redirect:/doList";
		
	}
    
	//跳转到修改页面,查找原来数据，并放入到request对象中
	@RequestMapping(value="/toEdit/{id}")
    public String toEdit(Model model,@PathVariable("id") Long postId)  {
		// TODO Auto-generated method stub
		Post post = postService.getInfo(postId);	
		model.addAttribute("post", post);
		return "pages/post_edit";		
	}
    @RequestMapping(value="/doReply")
	public String doReply(@RequestParam(value="pid") Long pid,
			              @RequestParam(value="content") String content,
			              HttpServletRequest request)  {
		// TODO Auto-generated method stub
	   User user = (User)request.getSession().getAttribute("USER");
	   Long uid = user.getId();
	   System.out.println(content+""+uid+pid);
	   Post post = new Post(content,uid,pid);
	   postService.reply(post);
	   
	   return "redirect:/toShow/"+pid;
	
	}
    @RequestMapping(value="/toShow/{pid}")
	public String toShow(Model model,@PathVariable("pid") Long postId) {
		// TODO Auto-generated method stub
		
		Post post = postService.showInfo(postId);
		model.addAttribute("post", post);
	    return "pages/post-info";	
	}
    @RequestMapping(value= "/doPublish")
	public String doPublish(
			Model model,@RequestParam("title") String title,
			                @RequestParam("content") String content,
			                HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("USER");
		Long uid = user.getId();
		Post post = new Post(null, title,content,null,null,uid,null);
		//PostService postService = new PostServiceImpl();
		boolean flag = false;
		try {
			flag = postService.publish(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag) {
			return "redirect:/doList";
			
		}else {
			model.addAttribute("message", "发布失败");
			return "pages/message";
		}
	}
    @RequestMapping(value = "/doList")
	public String doList(Model model)  {
		
		//查找帖子  转发到request portal中			
	    List<Post> plist = postService.showParents();
	    model.addAttribute("list", plist);
	    return "pages/portal";
	    
	}
    
}
