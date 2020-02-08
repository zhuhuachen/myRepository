package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.ItemRepository;
import com.example.demo.dao.SaleRepository;
import com.example.demo.dao.SalesLineItemRepository;
import com.example.demo.dao.StoreRepository;
import com.example.demo.entity.Item;
import com.example.demo.entity.Sale;
import com.example.demo.entity.SalesLineItem;
import com.example.demo.entity.Store;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired 
	private SaleRepository saleRepository;
	@Autowired 
	private StoreRepository storeRepository;
	@Autowired 
	private ItemRepository itemRepository;
	@Autowired 
	private SalesLineItemRepository salesLineItemRepository;
	
	
	
	@RequestMapping("/saleStart")
	public String saleStart(ModelMap map) {
	    return "views/sale_start";
	}
	
	@RequestMapping("/saleEnd")
	public String saleEnd(ModelMap map) {
	    return "views/sale_end";
	}
	@RequestMapping("/cashPay")
	public String cashPay(ModelMap map) {
	    return "views/cash_pay";
	}
	@RequestMapping("/cardPay")
	public String cardPay(ModelMap map) {
	    return "views/card_pay";
	}
	@RequestMapping("/enterItemView")
	public String enterItemView(ModelMap map) {
		
	    return "views/enterItem";
	}
	@ResponseBody
	@RequestMapping("/enterItem")
	public String enterItem(int barcode,String quantity) {
		JSONObject object = new JSONObject();
		 
		List<Sale> ss=saleRepository.findByIsReadytoPayAndIsComplete(true,false);
		if(ss==null||ss.size()==0) {
			object.put("msg", "300");
			String s=JSON.toJSONString(object);
			return s;
    	}
		List<Item> list=itemRepository.findByBarcode(barcode);
		if(list==null||list.size()==0) {
			object.put("msg","301");
		}else {
			Item item=list.get(0);
			float price=item.getPrice();
			int n=Integer.parseInt(quantity);
			float allprice=price*n;
			
			SalesLineItem sli=new SalesLineItem();
			sli.setQuantity(n);
			sli.setSubamount(allprice);
			
			sli.setBelongedSale(ss.get(0));
			sli.setBelongedItem(item);
			salesLineItemRepository.saveAndFlush(sli);
		}
		String s=JSON.toJSONString(object);
	    return s;
	}
	
	@ResponseBody
	@RequestMapping("/getInfo")
	public boolean getInfo() {
//	    Optional<Sale> o=saleRepository.findById(1);
//	    if(!o.isPresent()) {
//	    	
//	    }
    	List<Sale> list=saleRepository.findByIsReadytoPayAndIsComplete(true,false);
		
		if(list==null||list.size()==0) {
			return false;
    	}else {
    		return true;
    	}
	}
	@ResponseBody
    @RequestMapping("/start")
    public String start() {
		JSONObject object = new JSONObject();
		
		Optional<Store> os=storeRepository.findById(1);
		if(os.isPresent()) {
			boolean a=os.get().isOpened();
			if(!a) {
				object.put("code", 300);
				String s=JSON.toJSONString(object);
				return s;
			}
		}
		
		List<Sale> list=saleRepository.findByIsReadytoPayAndIsComplete(true,false);
		
		if(list==null||list.size()==0) {
			Sale s=new Sale();
			s.setReadytoPay(true);
			saleRepository.saveAndFlush(s);
			object.put("sale_id", s.getId());
    	}else {
    		Sale s=list.get(0);
    		s.setReadytoPay(true);
    		saleRepository.saveAndFlush(s);
    		object.put("sale_id", s.getId());
    	}
		object.put("code", 200);
		String s=JSON.toJSONString(object);
    	return s;
    }
    
	@ResponseBody
    @RequestMapping("/end")
    public String end() {
		JSONObject object = new JSONObject();
		
		List<Sale> list=saleRepository.findByIsReadytoPayAndIsComplete(true,false);
		
		if(list==null||list.size()==0) {
			object.put("code", 300);
			String s=JSON.toJSONString(object);
			return s;
    	}else {
    		
    		Sale s=list.get(0);
    		
    		List<SalesLineItem>sls=salesLineItemRepository.findByBelongedSale(s);
    		int sum=0;
    		for (SalesLineItem sl : sls) {
				sum+=sl.getSubamount();
			}
//    		s.setTime(new Date());
    		s.setComplete(true);
    		s.setAmount(sum);
    		saleRepository.saveAndFlush(s);
    		object.put("code", 200);
    	}
		String s=JSON.toJSONString(object);
		return s;
    }
}
