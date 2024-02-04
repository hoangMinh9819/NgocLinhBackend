package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findProductsByNameIsContaining(Pageable pageable, String name);

    Page<Product> findAll(Pageable pageable);
}
