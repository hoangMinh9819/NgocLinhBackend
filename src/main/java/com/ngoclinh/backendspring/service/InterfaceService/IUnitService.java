package com.ngoclinh.backendspring.service.InterfaceService;

import com.ngoclinh.backendspring.model.dto.UnitDTO;

import java.util.List;
import java.util.Optional;

public interface IUnitService {
    List<UnitDTO> showAll();
    List<UnitDTO> findByNameContaining(String name);
    UnitDTO findById(Long id);
    UnitDTO add(UnitDTO unitDTO);
    void delete(Long id);
    UnitDTO update(UnitDTO unitDTO);
}
