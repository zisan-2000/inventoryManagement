package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.ProductInfo;




@Repository
public interface MyProductRepository extends JpaRepository<ProductInfo,Long>{

}
