package com.ngoclinh.backendspring.service;

import com.ngoclinh.backendspring.exception.customException.DuplicateException;
import com.ngoclinh.backendspring.model.entity.Unit;
import com.ngoclinh.backendspring.model.dto.UnitDTO;
import com.ngoclinh.backendspring.mapper.UnitMapper;
import com.ngoclinh.backendspring.repository.UnitRepository;
import com.ngoclinh.backendspring.service.InterfaceService.IUnitService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitService implements IUnitService {
    private final UnitRepository unitRepository;

    @Override
    public List<UnitDTO> showAll() {
        List<Unit> units = unitRepository.findAll();

        if (units.isEmpty()) {
            throw new EntityNotFoundException("Không có dữ liệu nào");
        }

        return units.stream().map(UnitMapper::toDto).collect(Collectors.toList());
    }
    @Override
    public List<UnitDTO> findByNameContaining(String name) {
        List<Unit> units = unitRepository.findByNameContainingIgnoreCase(name);

        if (units.isEmpty()) {
            throw new EntityNotFoundException("Không tìm thấy Unit nào có tên chứa: " + name);
        }

        return units.stream().map(UnitMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UnitDTO findById(Long id) {
        return unitRepository.findById(id).map(UnitMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Unit not found for ID: " + id));
    }
    @Override
    public UnitDTO add(UnitDTO unitDTO) {
        if (unitRepository.existsUnitByName(unitDTO.getName()))
            throw new DuplicateException("Name " + unitDTO.getName() + " đã tồn tại");
        Unit unit = UnitMapper.toEntity(unitDTO);
        Unit savedUnit = unitRepository.save(unit);
        return UnitMapper.toDto(savedUnit);
    }

    @Override
    public void delete(Long id) {
        unitRepository.deleteById(id);
    }

    @Override
    public UnitDTO update(UnitDTO unitDTO) {
        // Kiểm tra Unit co
        unitRepository.findById(unitDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with ID: " + unitDTO.getId()));
        // Cập nhật dữ liệu từ DTO vào entity
        Unit unit = UnitMapper.toEntity(unitDTO);
        unit.setId(unitDTO.getId());

        // Trả về đối tượng DTO đã cập nhật
        return UnitMapper.toDto(unitRepository.save(unit));
    }
}
