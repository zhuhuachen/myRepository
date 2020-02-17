package com.example.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/test")
public class TestController {
	
//    @RequestMapping("/home")
//    public String home(ModelMap map) {
//
//    	return "views/home";
//    }
//    @RequestMapping("/home2")
//    public String home2(ModelMap map) {
//
//    	return "views/home2";
//    }

    
    @RequestMapping("/index")
    public String index(ModelMap map) {

    	return "index";
    }
    @RequestMapping("/index2")
    public String index2(ModelMap map) {

    	return "index2";
    }
    
//    @RequestMapping("/left")
//    public String left(ModelMap map) {
//
//    	return "left";
//    }
//    @RequestMapping("/top")
//    public String top(ModelMap map) {
//
//    	return "top";
//    }

}
