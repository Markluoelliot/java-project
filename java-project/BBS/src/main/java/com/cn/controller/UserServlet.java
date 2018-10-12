package com.cn.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.model.Post;
import com.cn.model.User;
import com.cn.service.PostService;
import com.cn.service.UserService;


/**
 * Servlet implementation class UserServlet
 */
@Controller
public class UserServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService; 
	@Autowired
	private PostService postService;
	@RequestMapping("/index")
	public String index() {
		return "pages/login"; 
	}
	
	@RequestMapping("login")
	public String login() {
		return "pages/login";
	}
	@RequestMapping(value="/portal")
	public String toPortal(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("USER");
		if(user!=null) {
			return "redirect:/doList";
		}else {
			return "pages/register";
		}
	}
	@RequestMapping(value = "/doLogin")
	public String doLogin(Model model,@RequestParam("account") String account,@RequestParam("password") String password,HttpServletRequest request) {
		User user = new User();
		
		user.setAccount(account);
		
		user.setPassword(password);
		
		User existUser = null;
		
		existUser = userService.login(user);
		
		if(existUser!= null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("USER", existUser);
			
			return "redirect:/doList";
			
		}else {
			String msg="登陆失败,密码或者账号错误";
		    request.setAttribute("message", msg);
		    return "pages/message";
		}
		
	}
	@RequestMapping(value="/doRegister")
	public String doRegister( @RequestParam("account") String account,
			                  @RequestParam("password") String password,
			                  @RequestParam("nickname") String nickname,
			                  @RequestParam("birthday") String bd) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		if(bd!=null) {
			try {
				birthday = dateformat.parse(bd);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		User user = new User(null,account,password,nickname,birthday);
		//UserService userservice = new UserServiceImpl();
		boolean flag = true;
		try {
			flag = userService.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag =false;
			e.printStackTrace();
		}
		return "pages/login";
	     
	}

	@RequestMapping(value = "/toRegister")
	public String toRegister() {
		
			return "/pages/register";
		
		
	}
    @RequestMapping(value = "/toLogin")
	public String toLogin() {
		
		
			return "pages/login";
		
	
	
}
	

}
