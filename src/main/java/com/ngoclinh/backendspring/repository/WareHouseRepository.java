package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.entity.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouse,Long> {
}
