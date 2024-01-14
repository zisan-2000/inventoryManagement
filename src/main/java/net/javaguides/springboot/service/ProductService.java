package net.javaguides.springboot.service;


import java.util.List;


import org.springframework.stereotype.Service;



import net.javaguides.springboot.entity.ProductInfo;
import net.javaguides.springboot.entity.ProductStock;
import net.javaguides.springboot.model.ProductInfoAndStockRequestModel;
import net.javaguides.springboot.util.BaseResponse;





@Service
public interface ProductService {
	
	
	
	//public void save(ProductInfo b) ;
	
	public void save(ProductInfo b) ;
	
	public void saveStock(ProductStock p) ;
	
	public List<ProductInfo> getAllProduct();
	
	public List<ProductStock> getAllProductStock();
	
	public ProductInfo getProductById(Long productId) ;
	
	public ProductStock getProductStockById(Long stockId) ;
	
	public void deleteById(Long productId) ;
	
	BaseResponse addProductInfoandStock(ProductInfoAndStockRequestModel request);
	
}
