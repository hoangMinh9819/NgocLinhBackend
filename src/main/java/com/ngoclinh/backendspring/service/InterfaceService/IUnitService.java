package com.ngoclinh.backendspring.service.InterfaceService;

import com.ngoclinh.backendspring.model.dto.UnitDTO;

import java.util.List;

public interface IUnitService {
    List<UnitDTO> showAllUnitsDTO();
    UnitDTO findByName(String name);
    UnitDTO findById(Long id);
    void addUnit (UnitDTO unitDTO);
    void deleteUnit(Long id);
    void updateUnit(UnitDTO unitDTO);
}
