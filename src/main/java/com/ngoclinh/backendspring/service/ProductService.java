package com.ngoclinh.backendspring.service;

import com.ngoclinh.backendspring.mapper.ProductMapper;
import com.ngoclinh.backendspring.model.dto.ProductDTO;
import com.ngoclinh.backendspring.model.dto.UnitDTO;
import com.ngoclinh.backendspring.model.entity.Product;
import com.ngoclinh.backendspring.model.entity.Unit;
import com.ngoclinh.backendspring.repository.ProductRepository;
import com.ngoclinh.backendspring.repository.UnitRepository;
import com.ngoclinh.backendspring.service.InterfaceService.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(productMapper::toDto);
    }

    @Override
    public Page<ProductDTO> findByName(Pageable pageable, String name) {
        System.out.println("IN findByName");
        Page<Product> products = productRepository.findProductsByNameIsContaining(pageable, name);
        Page<ProductDTO> productDTOS = products.map(productMapper::toDto);
        return productDTOS;
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        return productMapper.toDto(product);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        return productMapper.toDto(productRepository.save(product));
    }
    @Override
    public String updateProduct(ProductDTO productDTO) {
        Product existing = productRepository.findById(productDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        Product updated = productMapper.toEntity(productDTO);
        updated.setId(existing.getId());
        productRepository.save(updated);
        return "Update successful";
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
