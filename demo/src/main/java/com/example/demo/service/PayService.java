package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.CardPayRepository;
import com.example.demo.dao.CashPayRepository;
import com.example.demo.dao.SaleRepository;
import com.example.demo.entity.CardPayment;
import com.example.demo.entity.CashPayment;
import com.example.demo.entity.Sale;

@Service
public class PayService {
	
	@Autowired 
	private CashPayRepository cashPayRepository;
	@Autowired 
	private CardPayRepository cardPayRepository;
	@Autowired 
	private SaleRepository saleRepository;
	
    public String CashE(float amount) {
		JSONObject object = new JSONObject();
		List<Sale>sl=saleRepository.findByTimeIsNull();
		if(sl.size()!=0) {
			Sale s=sl.get(0);
			float a=s.getAmount();
			CashPayment cp=new CashPayment();
			cp.setBelongedSale(s);
			cp.setAmountTendered(amount);
			float b=amount-a;
			if(b<0) {
				object.put("code", 300);
				String data=JSON.toJSONString(object);
		    	return data;
			}else {
				cp.setBalance(b);
				cashPayRepository.saveAndFlush(cp);
				
				s.setTime(new Date());
				saleRepository.saveAndFlush(s);
				
				object.put("code", 200);
				String data=JSON.toJSONString(object);
		    	return data;
			}
		}
		object.put("code", 301);
		String s=JSON.toJSONString(object);
    	return s;
    }
    
    public String CardE(String number,String date,float fee) throws ParseException {
		JSONObject object = new JSONObject();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Sale>sl=saleRepository.findByTimeIsNull();
		if(sl.size()!=0) {
			Sale s=sl.get(0);
			float a=s.getAmount();
			CardPayment cp=new CardPayment();
			cp.setAmountTendered(a);
			cp.setBelongedSale(s);
			cp.setCardAccountNumber(number);
			cp.setFee(fee);
			Date d=formatter.parse(date);
			cp.setExpiryDate(d);
			cardPayRepository.saveAndFlush(cp);
			object.put("code", 200);
			
			String data=JSON.toJSONString(object);
			
			
			s.setTime(new Date());
			saleRepository.saveAndFlush(s);
	    	return data;
		}
		object.put("code", 301);
		String s=JSON.toJSONString(object);
    	return s;
    }
    
//	@Autowired 
//	private ItemRepository itemRepository;
	
//    @RequestMapping("/hello")
//    public String getList(ModelMap map) {
//    	
//    	List<Item> list=itemRepository.findAll();
//    	map.addAttribute("list", list);
//    	map.addAttribute("da", itemRepository.findByName("orange"));
//    	return "a";
//    }
}
