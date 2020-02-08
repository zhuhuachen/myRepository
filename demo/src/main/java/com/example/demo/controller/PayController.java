package com.example.demo.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.CardPayRepository;
import com.example.demo.dao.CashPayRepository;
import com.example.demo.dao.SaleRepository;
import com.example.demo.entity.CardPayment;
import com.example.demo.entity.CashPayment;
import com.example.demo.entity.Sale;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	@Autowired 
	private CashPayRepository cashPayRepository;
	@Autowired 
	private CardPayRepository cardPayRepository;
	@Autowired 
	private SaleRepository saleRepository;
	
	@RequestMapping("/cash")
	public String Info(ModelMap map) {
	    return "views/cash_pay";
	}
	@ResponseBody
    @RequestMapping("/cash_execute")
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
	@ResponseBody
    @RequestMapping("/card_execute")
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
}
