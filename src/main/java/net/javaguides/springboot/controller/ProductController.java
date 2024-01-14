package net.javaguides.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import net.javaguides.springboot.entity.ProductInfo;
import net.javaguides.springboot.entity.ProductStock;
import net.javaguides.springboot.model.ProductInfoAndStockRequestModel;
import net.javaguides.springboot.service.MyProductListService;
import net.javaguides.springboot.service.ProductService;





@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private MyProductListService myProductService;
	
//	@GetMapping("/")
//	public String home() {
//		return "home";
//	}
	
	@GetMapping("/product_register")
	public String productRegister() {
		return "productRegister";
	}
	
	@GetMapping("/available_products")
	public ModelAndView getAllProduct() {
		List<ProductInfo>list=service.getAllProduct();
//      ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("productList","product",list);
	}
	
//	@GetMapping("/available_products")
//	public ModelAndView getAllProduct() {
//		List<ProductInfo>list=service.getAllProduct();
//
//		return new ModelAndView("productList","product",list);
//	}
	
	@GetMapping("/available_products_stock")
	public ModelAndView getAllProductStock() {
		List<ProductStock>list=service.getAllProductStock();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("productStockList","stock",list);
	}
	
	@PostMapping("/save")
	public String addProduct(@ModelAttribute ProductInfo b) {
		service.save(b);
		return "redirect:/available_products";
	}
//	@PostMapping("/save")
//	public String addProduct(@ModelAttribute ProductInfoAndStockRequestModel request) {
//		service.save(request);
//		return "redirect:/available_products";
//	}
	
	@PostMapping("/addProductInfoandStock")
	public String addProductInfoandStock(@RequestBody ProductInfoAndStockRequestModel request) {
		 service.addProductInfoandStock(request);
		 return "redirect:/available_products";
	}
	
	@GetMapping("/my_products")
	public String getMyProducts(Model model)
	{
		List<ProductInfo>list=myProductService.getAllMyProducts();
		model.addAttribute("product",list);
		return "myProducts";
	}
	
	
	
	@GetMapping("/my_products_stock")
	public String getMyProductsStock(Model model)
	{
		List<ProductStock>list=myProductService.getAllMyProductsStock();
		model.addAttribute("stock",list);
		return "myProductsStock";
	}
	
	
	@RequestMapping("/myStocklist/{id}")
	public String getMyStockList(@PathVariable("id") Long stockId) {
		ProductStock p=service.getProductStockById(stockId);
		ProductStock ps=new ProductStock(p.getId(),p.getStockName(),p.getStockQty(),p.getCreateDate(), p.getStatus());
		myProductService.saveMyProductsStock(ps);
		return "redirect:/my_products_stock";
	}
	
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") Long productId) {
		ProductInfo b=service.getProductById(productId);
		ProductInfo mb=new ProductInfo(b.getId(),b.getProductName(),b.getProductType(),b.getProductUnitPrice(),b.getProductPurchasePrice(),b.getProductSellingPrice(),b.getCreatedDate(),b.getStatus());
		myProductService.saveMyProducts(mb);
		return "redirect:/my_products";
	}
	
	@RequestMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") Long productId,Model model) {
		ProductInfo b=service.getProductById(productId);
		model.addAttribute("product",b);
		return "productEdit";
	}
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id")Long productId) {
		service.deleteById(productId);
		return "redirect:/available_products";
	}
	
//	@PostMapping("/addProductInfoandStock")
//	BaseResponse addProductInfoandStock(@RequestBody ProductInfoAndStockRequestModel request) {
//		return service.addProductInfoandStock(request);
//	}
	
	
	
//	@PostMapping("/save")
//	public String addProduct(@ModelAttribute ProductInfoAndStockRequestModel request) {
//		service.addProductInfoandStock(request);
//		return "redirect:/available_products";
//	}
	
	
}
