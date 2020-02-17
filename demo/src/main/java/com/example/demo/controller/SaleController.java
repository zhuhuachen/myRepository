package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.SaleService;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired 
	private SaleService saleService;

	
	
	
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
	    return saleService.enterItem(barcode, quantity);
	}
	
	@ResponseBody
	@RequestMapping("/getInfo")
	public boolean getInfo() {
		return saleService.getInfo();
	}
	@ResponseBody
    @RequestMapping("/start")
    public String start() {
		return saleService.start();
    }
    
	@ResponseBody
    @RequestMapping("/end")
    public String end() {
		return saleService.end();
    }
}
