package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.entity.ProductInfo;
import net.javaguides.springboot.repository.ProductInfoRepository;

@Service
public class ProductInfoService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    public List<ProductInfo> getAllProductInfo() {
        return productInfoRepository.findAll();
    }
}
