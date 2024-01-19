package com.ngoclinh.backendspring.service.InterfaceService;

import com.ngoclinh.backendspring.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> showAllProducts();
    List<ProductDTO> findByName(String name);
    ProductDTO findById(Long id);
    void addProduct (ProductDTO productDTO);
    void deleteProduct(Long id);
    void updateProduct(ProductDTO productDTO);
}
