package com.ngoclinh.backendspring.controller;

import com.ngoclinh.backendspring.model.dto.ProductDTO;
import com.ngoclinh.backendspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;
    @GetMapping()
    public Page<ProductDTO> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return productService.findAll(pageable);
    }
    @GetMapping("/search/{name}")
    public Page<ProductDTO> getAllProductsByName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @PathVariable String name){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return productService.findByName(pageable, name);
    }
    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return productService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    @PostMapping()
    public String addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
        return "Create successful";
    }
    @PutMapping()
    public String updateProduct(@RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }
}
