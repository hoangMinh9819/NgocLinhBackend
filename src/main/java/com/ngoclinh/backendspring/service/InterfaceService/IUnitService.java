package com.ngoclinh.backendspring.service.InterfaceService;

import com.ngoclinh.backendspring.dto.UnitDTO;
import com.ngoclinh.backendspring.model.Unit;

import java.util.List;

public interface IUnitService {
    List<UnitDTO> showAllUnits();
    UnitDTO findByName(String name);
    UnitDTO findById(Long id);
    void addUnit (UnitDTO unitDTO);
    void deleteUnit(Long id);
    void updateUnit(UnitDTO unitDTO);
}
