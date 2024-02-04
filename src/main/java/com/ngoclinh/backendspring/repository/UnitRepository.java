package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Long> {

    Unit findUnitByName(String name);
    boolean existsUnitByName(String name);
    List<Unit> findByNameContainingIgnoreCase(String name);
}
