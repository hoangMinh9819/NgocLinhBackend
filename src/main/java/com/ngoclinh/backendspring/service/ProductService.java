package com.ngoclinh.backendspring.service;

import com.ngoclinh.backendspring.dto.ProductDTO;
import com.ngoclinh.backendspring.dto.UnitDTO;
import com.ngoclinh.backendspring.model.Product;
import com.ngoclinh.backendspring.model.Unit;
import com.ngoclinh.backendspring.repository.ProductRepository;
import com.ngoclinh.backendspring.repository.UnitRepository;
import com.ngoclinh.backendspring.service.InterfaceService.IProductService;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UnitRepository unitRepository;
    public UnitDTO unitDTO(Unit unit){
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setId(unit.getId());
        unitDTO.setName(unit.getName());
        return unitDTO;
    }
    public Unit fetchUnit(UnitDTO unitDTO){
        Unit unit = unitRepository.getReferenceById(unitDTO.getId());
        return unit;
    }
    public ProductDTO buildProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setSupplier(product.getSupplier());
        productDTO.setPacking(product.getPacking());
        productDTO.setSalePrice(product.getSalePrice());
        productDTO.setPurchasePrice(product.getPurchasePrice());
        productDTO.setUnitPurchase(unitDTO(product.getUnitPurchase()));
        productDTO.setUnitSale(unitDTO(product.getUnitSale()));
        productDTO.setExpiry(product.getExpiry());
        return productDTO;
    }
    @Override
    public List<ProductDTO> showAllProducts() {
        List<Product> products = productRepository.findAllByOrderByProductIdAsc();
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(product -> {
            productDTOS.add(buildProductDTO(product));
        });
        return productDTOS;
    }

    @Override
    public List<ProductDTO> findByName(String name) {
        System.out.println("IN findByName");
        List<Product> products = productRepository.findByNameContainingIgnoreCaseOrderByProductId(name);
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(product -> {
            productDTOS.add(buildProductDTO(product));
        });
        return productDTOS;
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        return buildProductDTO(product);
    }
    public void addAndUpdateProduct(Product product, ProductDTO productDTO){
        product.setName(productDTO.getName());
        product.setPurchasePrice(productDTO.getPurchasePrice());
        product.setSalePrice(productDTO.getSalePrice());
        product.setUnitPurchase(fetchUnit(productDTO.getUnitPurchase()));
        product.setUnitSale(fetchUnit(productDTO.getUnitSale()));
        product.setPacking(productDTO.getPacking());
        product.setExpiry(productDTO.getExpiry());
        productRepository.save(product);
    }
    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        addAndUpdateProduct(product, productDTO);
    }
    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).get();
        addAndUpdateProduct(product, productDTO);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
