package com.ngoclinh.backendspring.service;

import com.ngoclinh.backendspring.mapper.UnitMapper;
import com.ngoclinh.backendspring.mapper.WareHouseMapper;
import com.ngoclinh.backendspring.model.dto.WareHouseDTO;
import com.ngoclinh.backendspring.model.entity.Unit;
import com.ngoclinh.backendspring.model.entity.WareHouse;
import com.ngoclinh.backendspring.repository.WareHouseRepository;
import com.ngoclinh.backendspring.service.InterfaceService.IWareHouseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WareHouseService implements IWareHouseService {
    private final WareHouseRepository wareHouseRepository;
    @Override
    public List<WareHouseDTO> findAll() {
        List<WareHouse> wareHouseList = wareHouseRepository.findAll();

        if (wareHouseList.isEmpty()) {
            throw new EntityNotFoundException("Không có dữ liệu nào");
        }
        return wareHouseList.stream().map(WareHouseMapper::toDto).collect(Collectors.toList());
    }
}
