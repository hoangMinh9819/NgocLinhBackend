package com.ngoclinh.backendspring.service;

import com.ngoclinh.backendspring.dto.UnitDTO;
import com.ngoclinh.backendspring.model.Unit;
import com.ngoclinh.backendspring.repository.UnitRepository;
import com.ngoclinh.backendspring.service.InterfaceService.IUnitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService implements IUnitService {
    @Autowired
    private UnitRepository unitRepository;
    @Override
    public List<UnitDTO> showAllUnits() {
        List<Unit> unitList = unitRepository.findAll();
        List<UnitDTO> unitDTOS = new ArrayList<>();
        //1. lap
        unitList.forEach(unit -> {
            //2. tao unitdto ->
            UnitDTO unitDTO = new UnitDTO();
            //3. set thuoc tinh cua unit vao unitdto
            unitDTO.setId(unit.getId());
            unitDTO.setName(unit.getName());
            //4. day vao
            unitDTOS.add(unitDTO);
        });
        return unitDTOS;
    }

    @Override
    public UnitDTO findByName(String name) {
        Unit unit = unitRepository.findByName(name);
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setId(unit.getId());
        unitDTO.setName(unit.getName());
        return unitDTO;
    }

    @Override
    public UnitDTO findById(Long id) {
        Unit unit = unitRepository.findById(id).get();
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setId(unit.getId());
        unitDTO.setName(unit.getName());
        return unitDTO;
    }

    @Override
    public void addUnit(UnitDTO unitDTO) {
        Unit unit = new Unit();
        unit.setName(unitDTO.getName());
        unitRepository.save(unit);
    }

    @Override
    public void deleteUnit(Long id) {
        unitRepository.deleteById(id);
    }

    @Override
    public void updateUnit(UnitDTO unitDTO) {
        Unit unit = unitRepository.findById(unitDTO.getId()).get();
        unit.setName(unitDTO.getName());
        unitRepository.save(unit);
    }

}
