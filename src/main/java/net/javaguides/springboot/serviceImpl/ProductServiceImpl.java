package net.javaguides.springboot.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import net.javaguides.springboot.entity.ProductInfo;
import net.javaguides.springboot.entity.ProductStock;
import net.javaguides.springboot.model.ProductInfoAndStockRequestModel;
import net.javaguides.springboot.repository.ProductRepository;
import net.javaguides.springboot.repository.ProductStockRepository;
import net.javaguides.springboot.service.ProductService;
import net.javaguides.springboot.util.BaseResponse;




@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	 ProductRepository pRepo;
	
	@Autowired
	 ProductStockRepository proStockRepo;

	@Override
	public void save(ProductInfo b) {
		pRepo.save(b);
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void saveStock(ProductStock p) {
		proStockRepo.save(p);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductInfo> getAllProduct() {
		// TODO Auto-generated method stub
		return pRepo.findAll();
	}
	
	@Override
	public List<ProductStock> getAllProductStock() {
		// TODO Auto-generated method stub
		return proStockRepo.findAll();
	}

	@Override
	public ProductInfo getProductById(Long productId) {
		// TODO Auto-generated method stub
		return pRepo.findById(productId).get();
	}

	@Override
	public void deleteById(Long productId) {
		// TODO Auto-generated method stub
		pRepo.deleteById(productId);
	
	}

	@Override
	public ProductStock getProductStockById(Long stockId) {
		// TODO Auto-generated method stub
		return proStockRepo.findById(stockId).get();
	}

	
	@Override
	public BaseResponse addProductInfoandStock(ProductInfoAndStockRequestModel request) {
		BaseResponse baseResponse = new BaseResponse();
		ProductInfo productInfo = productInfoModeltoEntity(request);
		try {
			
			pRepo.save(productInfo);
			baseResponse.setMessage("Product Entry Success");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return baseResponse;
	}

ProductInfo productInfoModeltoEntity(ProductInfoAndStockRequestModel request) {
	
	ProductInfo productInfo = new ProductInfo();	
	BeanUtils.copyProperties(request, productInfo);
	
	
	List<ProductStock> productStocks = new ArrayList<>();
	
	String loop = request.getStockName();
	if(loop.contains(",")) {
		String[] stockName = loop.trim().split(",");
		String[] stockQty = request.getStockQty().trim().split(",");
		
		for(int i=0; i<stockName.length; i++) {
			
			ProductStock productStock = new ProductStock();
			
			productStock.setStockName(stockName[i]);
			productStock.setStockQty(Double.parseDouble(stockQty[i]));
			productStock.setStatus(request.getStatus());
			productStock.setProductInfo(productInfo); 
			
			productStocks.add(productStock);
		}
		
	}
	
	productInfo.setProductStock(productStocks); 
	
	return productInfo;
	
}


	

	

}
