package net.javaguides.springboot.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


import lombok.Data;
import net.javaguides.springboot.entity.ProductInfo;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
	
	String message;
	
	List<ProductInfo> productList;
}
