package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.entity.ProductStock;





@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock,Long>  {

}
