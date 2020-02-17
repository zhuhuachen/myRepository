package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.StoreRepository;
import com.example.demo.entity.Store;

@Service
public class StoreService {
	
	@Autowired 
	private StoreRepository storeRepository;

	
	public String Info(ModelMap map) {
	    Store s=storeRepository.findById(1).get();
	    if(s==null) {
	    	map.addAttribute("msg", "eror");
	    }else {
	    	map.addAttribute("msg", "success");
	    }
	    return "store";
	}
	
	public boolean getInfo() {
	    Store s=storeRepository.findById(1).get();
	    boolean a=s.isOpened();
    	return a;
	}
	
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
    public String T1() {
		JSONObject object = new JSONObject();
		List<Store>list=storeRepository.findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
    	return s;
    }
    
}
