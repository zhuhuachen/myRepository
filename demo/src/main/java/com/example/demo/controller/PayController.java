package com.example.demo.controller;



import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.service.PayService;

@Controller
@RequestMapping("/pay")
public class PayController {
	
	@Autowired 
	private PayService payService;
	
	@RequestMapping("/cash")
	public String Info(ModelMap map) {
	    return "views/cash_pay";
	}
	@ResponseBody
    @RequestMapping("/cash_execute")
    public String CashE(float amount) {
    	return payService.CashE(amount);
    }
	@ResponseBody
    @RequestMapping("/card_execute")
    public String CardE(String number,String date,float fee) throws ParseException {
		return payService.CardE(number, date, fee);
    }
}
