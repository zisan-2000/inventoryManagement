package net.javaguides.springboot.service;

import java.util.List;


import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.ProductInfo;
import net.javaguides.springboot.entity.ProductStock;




@Service
public interface MyProductListService {
	
	
	
	public void saveMyProducts(ProductInfo product);
	
	public void saveMyProductsStock(ProductStock stock);
	
	public List<ProductInfo> getAllMyProducts();
	
	public List<ProductStock> getAllMyProductsStock();
	
	public void deleteById(Long productId) ;
	
	public void deleteByStockId(Long stockId) ;
}
