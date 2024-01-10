package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.Product;
import com.ngoclinh.backendspring.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCaseOrderByProductId(String name);
    List<Product> findAllByOrderByProductIdAsc();
}
