package com.luo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String ts(Model model) {
    	model.addAttribute("key", 1);
    	model.addAttribute("feeds", "abc");
    	return "test";
    }
}
