package net.javaguides.springboot.model;



import lombok.Data;

@Data
public class ProductInfoAndStockRequestModel {
	
	private String productName;
	private String productType;
	private int productUnitPrice;
	private double productPurchasePrice;
	private double productSellingPrice;
	private String status;
	private String stockName;
	private String stockQty;
	
	

}