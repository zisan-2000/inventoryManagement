package net.javaguides.springboot.entity;



import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import javax.persistence.SequenceGenerator;



import lombok.Data;

@Entity
@Data

public class Product {

	@Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @Column(
            name = "productId",
            updatable = false
    )
    private Long id;
	private String productName;
	private String productType;
	private int productUnitPrice;
	private double productPurchasePrice;
	private double productSellingPrice;
	private Date createdDate = new Date();
	private String status;
//
//	@OneToOne(mappedBy = "productInfo", cascade = CascadeType.ALL)
//	private ProductStock productStock;
//	
//	@OneToMany(mappedBy = "productInfo", cascade = CascadeType.ALL)
//	private List<ProductStock> productStock;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, String productName, String productType, int productUnitPrice, 
			double productPurchasePrice, double productSellingPrice, Date createdDate, String status) {
		super();
		this.id = id;
		this.productName = productName;
		this.productType = productType;
		this.productUnitPrice = productUnitPrice;
		this.productPurchasePrice = productPurchasePrice;
		this.productSellingPrice = productSellingPrice;
		this.createdDate = createdDate;
		this.status = status;

}
}
