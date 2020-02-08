package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.CardPayRepository;
import com.example.demo.dao.CashDeskRepository;
import com.example.demo.dao.CashPayRepository;
import com.example.demo.dao.SaleRepository;
import com.example.demo.dao.SalesLineItemRepository;
import com.example.demo.dao.StoreRepository;
import com.example.demo.entity.CardPayment;
import com.example.demo.entity.CashPayment;
import com.example.demo.entity.Sale;
import com.example.demo.entity.SalesLineItem;
import com.example.demo.entity.Store;

@Controller
@RequestMapping("/table")
public class TableController {
	
	@Autowired 
	private StoreRepository storeRepository;
	@Autowired 
	private SaleRepository saleRepository;
	@Autowired 
	private SalesLineItemRepository salesLineItemRepository;
	@Autowired 
	private CashPayRepository cashPayRepository;
	@Autowired 
	private CardPayRepository cardPayRepository;
//	@ResponseBody
//    @RequestMapping("/store")
//    public String CardE() {
//		JSONObject object = new JSONObject();
//		object.put("code", 200);
//		String s=JSON.toJSONString(object);
//    	return s;
//    }
	@ResponseBody
    @RequestMapping("/store")
    public String T1() {
		JSONObject object = new JSONObject();
		
		List<Store>list=storeRepository.findAll();
		
		object.put("list", list);
		
		String s=JSON.toJSONString(object);
		
    	return s;
    }
	@ResponseBody
    @RequestMapping("/sale")
    public String T2() {
		JSONObject object = new JSONObject();
		
		List<Sale>list=saleRepository.findFirstByOrderByIdDesc();
		object.put("list", list);
		
		String s=JSON.toJSONString(object);
		
    	return s;
    }
	@ResponseBody
    @RequestMapping("/salesLineItem")
    public String T3() {
		JSONObject object = new JSONObject();
		List<Sale>ls=saleRepository.findFirstByOrderByIdDesc();
		if(ls.size()==0) {
			object.put("list", null);
			String s=JSON.toJSONString(object);
	    	return s;
		}else {
			
		}
		List<SalesLineItem>list=salesLineItemRepository.findByBelongedSale(ls.get(0));
		
		object.put("list", list);
		
		String s=JSON.toJSONString(object);
		
    	return s;
    }
	@ResponseBody
    @RequestMapping("/cashPay")
    public String T4() {
		JSONObject object = new JSONObject();
		List<Sale>ls=saleRepository.findFirstByOrderByIdDesc();
		if(ls.size()==0) {
			object.put("list", null);
			String s=JSON.toJSONString(object);
	    	return s;
		}else {
			
		}
		List<CashPayment>list=cashPayRepository.findByBelongedSale(ls.get(0));
		object.put("list", list);
		
		String s=JSON.toJSONString(object);
		
    	return s;
    }
	@ResponseBody
    @RequestMapping("/cardPay")
    public String T5() {
		JSONObject object = new JSONObject();
		List<Sale>ls=saleRepository.findFirstByOrderByIdDesc();
		if(ls.size()==0) {
			object.put("list", null);
			String s=JSON.toJSONString(object);
	    	return s;
		}else {
			
		}
		List<CardPayment>list=cardPayRepository.findByBelongedSale(ls.get(0));
		object.put("list", list);
		String s=JSON.toJSONString(object);
    	return s;
    }
}
