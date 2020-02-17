package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.SaleService;
import com.example.demo.service.StoreService;

@Controller
@RequestMapping("/table")
public class TableController {
	
	@Autowired 
	private StoreService storeService;
	@Autowired 
	private SaleService saleService;

	@ResponseBody
    @RequestMapping("/store")
    public String store() {
    	return storeService.T1();
    }
	@ResponseBody
    @RequestMapping("/sale")
    public String sale() {
		return saleService.T2();
    }
	@ResponseBody
    @RequestMapping("/salesLineItem")
    public String salesLineItem() {
		return saleService.T3();
    }
	@ResponseBody
    @RequestMapping("/cashPay")
    public String cashPay() {
		return saleService.T4();
    }
	@ResponseBody
    @RequestMapping("/cardPay")
    public String cardPay() {
		return saleService.T5();
    }
}
