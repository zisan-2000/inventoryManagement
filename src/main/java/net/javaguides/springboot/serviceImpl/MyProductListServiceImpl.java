package net.javaguides.springboot.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.ProductInfo;
import net.javaguides.springboot.entity.ProductStock;
import net.javaguides.springboot.repository.MyProductRepository;
import net.javaguides.springboot.repository.ProductStockRepository;
import net.javaguides.springboot.service.MyProductListService;



@Service
public class MyProductListServiceImpl implements MyProductListService {
	
	@Autowired
	 MyProductRepository myproduct;
	
	@Autowired
	 ProductStockRepository proStockRepo;
	
	@Override
	public void saveMyProducts (ProductInfo product) {
		// TODO Auto-generated method stub
		myproduct.save(product);
	}
	
	@Override
	public void saveMyProductsStock (ProductStock stock) {
		// TODO Auto-generated method stub
		proStockRepo.save(stock);
	}

	@Override
	public List<ProductInfo> getAllMyProducts() {
		// TODO Auto-generated method stub
		return myproduct.findAll();
	}
	
	

	@Override
	public void deleteById(Long productId) {
		// TODO Auto-generated method stub
		myproduct.deleteById(productId);
		
	}

	@Override
	public List<ProductStock> getAllMyProductsStock() {
		// TODO Auto-generated method stub
		return proStockRepo.findAll();
		
	}

	@Override
	public void deleteByStockId(Long stockId) {
		// TODO Auto-generated method stub
		proStockRepo.deleteById(stockId);
		
	}

}
