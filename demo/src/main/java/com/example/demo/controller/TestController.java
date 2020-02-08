package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ItemRepository;
import com.example.demo.entity.Item;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired 
	private ItemRepository itemRepository;
	
    @RequestMapping("/hello")
    public String getList(ModelMap map) {
    	
    	List<Item> list=itemRepository.findAll();
    	map.addAttribute("list", list);
    	map.addAttribute("da", itemRepository.findByName("orange"));
    	return "a";
    }
    @RequestMapping("/home")
    public String home(ModelMap map) {

    	return "views/home";
    }
    @RequestMapping("/home2")
    public String home2(ModelMap map) {

    	return "views/home2";
    }

    
    @RequestMapping("/index")
    public String index(ModelMap map) {

    	return "index";
    }
    @RequestMapping("/index2")
    public String index2(ModelMap map) {

    	return "index2";
    }
    
    @RequestMapping("/left")
    public String left(ModelMap map) {

    	return "left";
    }
    @RequestMapping("/top")
    public String top(ModelMap map) {

    	return "top";
    }

}
