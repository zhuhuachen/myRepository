package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.StoreRepository;
import com.example.demo.entity.Store;

@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired 
	private StoreRepository storeRepository;
	
	@RequestMapping("/info")
	public String Info(ModelMap map) {
	    Store s=storeRepository.findById(1).get();
	    if(s==null) {
	    	map.addAttribute("msg", "eror");
	    }else {
	    	map.addAttribute("msg", "success");
	    }
	    return "store";
	}
	@ResponseBody
	@RequestMapping("/getInfo")
	public boolean getInfo() {
	    Store s=storeRepository.findById(1).get();
	    boolean a=s.isOpened();
    	return a;
	}
	@ResponseBody
    @RequestMapping("/start")
    public String start() {
    	Store s=storeRepository.findById(1).get();
    	if(s==null) {
    		return "error";
    	}else {
    		s.setOpened(true);
    		storeRepository.saveAndFlush(s);
    	}
    	return "success";
    }
    
	@ResponseBody
    @RequestMapping("/end")
    public String end() {
    	Store s=storeRepository.findById(1).get();
    	if(s==null) {
    		return "error";
    	}else {
    		s.setOpened(false);
    		storeRepository.saveAndFlush(s);
    	}
    	return "success";
    }
}
