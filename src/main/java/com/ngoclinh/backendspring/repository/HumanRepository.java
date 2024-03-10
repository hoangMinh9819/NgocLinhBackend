package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
    Optional<Human> findByUsername(String username);
}
