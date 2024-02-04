package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HumanRepository extends JpaRepository<Human, Long> {
    Optional<Human> findByUsername(String username);
}
