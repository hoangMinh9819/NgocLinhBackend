package com.ngoclinh.backendspring.controller;

import com.ngoclinh.backendspring.model.dto.ProductDTO;
import com.ngoclinh.backendspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(){
        return productService.showAllProducts();
    }
    @GetMapping("/productsByName/{name}")
    public List<ProductDTO> getAllProductsByName(@PathVariable String name){
        return productService.findByName(name);
    }
    @GetMapping("/productById/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return productService.findById(id);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody ProductDTO productDTO){
        productService.addProduct(productDTO);
    }
    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody ProductDTO productDTO){ productService.updateProduct(productDTO);}
}
