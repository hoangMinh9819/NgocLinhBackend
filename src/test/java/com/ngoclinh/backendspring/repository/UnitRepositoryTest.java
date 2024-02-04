package com.ngoclinh.backendspring.repository;

import com.ngoclinh.backendspring.model.entity.Unit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UnitRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UnitRepository unitRepository;
    @Test
    public void whenFindByName_thenReturnUnit() {
        // given
        Unit givenUnit = new Unit();
        givenUnit.setName("Thung");
        Unit givenUnit2 = new Unit();
        givenUnit2.setName("Hop");
        Unit givenUnit3 = new Unit();
        givenUnit3.setName("Vien");
        entityManager.persist(givenUnit);
        entityManager.persist(givenUnit2);
        entityManager.persist(givenUnit3);
        entityManager.flush();

        // when
        Unit foundUnit = unitRepository.findUnitByName("Hop");

        // then
        assertEquals(foundUnit.getName(),givenUnit2.getName());
    }
}