package net.javaguides.springboot.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Entity
@Data
@Table(name="Product_Stock",indexes= {@Index(name="stockId",columnList="stockId",unique=true)})
public class ProductStock {

	@Id
	@SequenceGenerator(
			name = "stock_sequence",
            sequenceName = "stock_sequence",
            initialValue = 1,
            allocationSize = 1			
			)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_sequence"
    )	
    @Column(
            name = "stockId",
            updatable = false
    )
    private Long id;
	private String stockName;
	private double stockQty;
	private String status;
	private Date createDate = new Date();
	
//	@OneToOne
//  @JoinColumn(name = "parent_product_id", referencedColumnName = "productId")
//	@JsonIgnore
//  private ProductInfo productInfo;
	
	@ManyToOne

	@OneToOne
    @JoinColumn(name = "parent_product_id", referencedColumnName = "productId")
	@JsonIgnore
    private ProductInfo productInfo;
	
	public ProductStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductStock(Long id, String stockName,  
			double stockQty,  Date createdDate, String status) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.stockQty = stockQty;
		this.createDate = createdDate;
		this.status = status;

}
}
