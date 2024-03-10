package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.entity.Product;
import com.ngoclinh.backendspring.model.entity.WareHouse;
import com.ngoclinh.backendspring.model.entity.WareHouseDetails;
import com.ngoclinh.backendspring.model.entity.WareHouseDetailsID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseDetailRepository extends JpaRepository<WareHouseDetails, WareHouseDetailsID> {
    Page<WareHouseDetails> findAllByWareHouseId(Pageable pageable, WareHouse wareHouse);
}
