package com.ngoclinh.backendspring.service;

import com.ngoclinh.backendspring.exception.customException.NotFoundException;
import com.ngoclinh.backendspring.model.Unit;
import com.ngoclinh.backendspring.model.dto.UnitDTO;
import com.ngoclinh.backendspring.model.dto.mapper.UnitMapper;
import com.ngoclinh.backendspring.repository.UnitRepository;
import com.ngoclinh.backendspring.service.InterfaceService.IUnitService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitService implements IUnitService {

    private final UnitRepository unitRepository;

    @Override
    public List<UnitDTO> showAllUnitsDTO() {
        List<Unit> unitList = unitRepository.findAll();
        if (unitList.isEmpty()) throw new NotFoundException("get all unit", "không có dữ liệu nào về đối tượng này");
        List<UnitDTO> unitDTOS = new ArrayList<>();
        unitList.forEach(unit -> {
            UnitDTO unitDTO = UnitMapper.convertToDto(unit);
            unitDTOS.add(unitDTO);
        });
        return unitDTOS;
    }

    @Override
    public UnitDTO findByName(String name) {
        Unit unit = unitRepository.findByNameContaining(name);
        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setId(unit.getId());
        unitDTO.setName(unit.getName());
        return unitDTO;
    }
    /**
     * Retrieves a unit by its unique identifier and converts it to a data transfer object (DTO).
     * This method provides a way to access unit data in a form that's convenient for client-side use.
     * If the unit with the specified ID is not found, this method throws an EntityNotFoundException.
     *
     * @param id the unique identifier of the unit to be retrieved
     * @return a representation of the unit as a UnitDTO object
     * @throws EntityNotFoundException if the unit with the specified ID does not exist
     */
    @Override
    public UnitDTO findById(Long id) {
        return unitRepository.findById(id)
                .map(UnitMapper::convertToDto)
                .orElseThrow(() -> new EntityNotFoundException("Unit not found for ID: " + id));
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

    }
}
