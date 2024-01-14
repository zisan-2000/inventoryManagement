package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.entity.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
    // Add custom queries if needed
}
