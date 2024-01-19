package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit,Long> {
    Unit findByNameContaining(String name);
}
