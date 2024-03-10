package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.entity.Product;
import com.ngoclinh.backendspring.model.entity.WareHouse;
import com.ngoclinh.backendspring.model.entity.WareHouseDetails;
import com.ngoclinh.backendspring.model.entity.WareHouseDetailsID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class WareHouseDetailRepositoryTest {
    @Autowired private WareHouseRepository wareHouseRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private WareHouseDetailRepository wareHouseDetailRepository;
    @Test
    public void testListAll(){
        Iterable<WareHouseDetails> wareHouseDetails = wareHouseDetailRepository.findAll();
        assertNotNull(wareHouseDetails);
        wareHouseDetails.forEach(System.out::println);
    }
    @Test
    public void testSaveNew(){
        WareHouse wareHouse = wareHouseRepository.findById(1L).get();
        Product product = productRepository.findById(405L).get();
        WareHouseDetails wareHouseDetail = new WareHouseDetails();
        wareHouseDetail.setWareHouseId(wareHouse);
        wareHouseDetail.setProductId(product);
        wareHouseDetail.setQuantity(100);
        WareHouseDetails savedWareHouseDetails = wareHouseDetailRepository.save(wareHouseDetail);
        assertNotNull(savedWareHouseDetails);
        assertEquals(savedWareHouseDetails.getWareHouseId().getName(),"chi nhanh 1");
        assertEquals(savedWareHouseDetails.getProductId().getName(),"Khẩu Trang Trắng");
    }
    @Test
    public void findbyid(){
        WareHouse wareHouse = wareHouseRepository.findById(2L).get();
        Product product = productRepository.findById(405L).get();
        WareHouseDetailsID id = new WareHouseDetailsID();
        id.setWareHouseId(wareHouse);
        id.setProductId(product);
        Optional<WareHouseDetails> wareHouseDetails = wareHouseDetailRepository.findById(id);
        assertFalse(wareHouseDetails.isPresent());


        WareHouse wareHouse1 = wareHouseRepository.findById(1L).get();
        WareHouseDetailsID id1 = new WareHouseDetailsID();
        id1.setWareHouseId(wareHouse1);
        id1.setProductId(product);
        Optional<WareHouseDetails> wareHouseDetails1 = wareHouseDetailRepository.findById(id1);
        assertTrue(wareHouseDetails1.isPresent());
        System.out.println(wareHouseDetails1);
    }
}