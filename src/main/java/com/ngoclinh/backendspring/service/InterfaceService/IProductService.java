package com.ngoclinh.backendspring.service.InterfaceService;

import com.ngoclinh.backendspring.model.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<ProductDTO> findByName(Pageable pageable, String name);
    ProductDTO findById(Long id);
    ProductDTO addProduct (ProductDTO productDTO);
    void deleteProduct(Long id);
    String updateProduct(ProductDTO productDTO);
    Page<ProductDTO> findAll(Pageable pageable);
}
