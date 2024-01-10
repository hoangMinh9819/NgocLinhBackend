package com.ngoclinh.backendspring.controller;

import com.ngoclinh.backendspring.dto.ProductDTO;
import com.ngoclinh.backendspring.dto.UnitDTO;
import com.ngoclinh.backendspring.service.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductService productService;
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
