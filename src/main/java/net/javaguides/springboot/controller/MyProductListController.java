package net.javaguides.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.MyProductListService;




@Controller
public class MyProductListController {
	
	@Autowired
	private MyProductListService service;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") Long productId) {
		service.deleteById(productId);
		return "redirect:/my_products";
	}
	
	@RequestMapping("/deleteMyStockList/{id}")
	public String deleteMyStockList(@PathVariable("id") Long stockId) {
		service.deleteByStockId(stockId);
		return "redirect:/my_products_stock";
	}
}
