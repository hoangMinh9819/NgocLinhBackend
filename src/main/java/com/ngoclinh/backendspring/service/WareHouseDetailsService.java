package com.ngoclinh.backendspring.service;

import com.ngoclinh.backendspring.mapper.WareHouseDetailsMapper;
import com.ngoclinh.backendspring.model.dto.WareHouseDetailsDTO;
import com.ngoclinh.backendspring.model.entity.WareHouse;
import com.ngoclinh.backendspring.model.entity.WareHouseDetails;
import com.ngoclinh.backendspring.model.entity.WareHouseDetailsID;
import com.ngoclinh.backendspring.repository.WareHouseDetailRepository;
import com.ngoclinh.backendspring.repository.WareHouseRepository;
import com.ngoclinh.backendspring.service.InterfaceService.IWareHouseDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class WareHouseDetailsService implements IWareHouseDetailsService {
    private final WareHouseDetailRepository wareHouseDetailRepository;
    private final WareHouseDetailsMapper wareHouseDetailsMapper;
    private final WareHouseRepository wareHouseRepository;
    @Override
    public Page<WareHouseDetailsDTO> findAllById(Pageable pageable, Long id) {
        WareHouse wareHouse = wareHouseRepository.findById(id).get();
        Page<WareHouseDetails> wareHouseDetailsList = wareHouseDetailRepository.findAllByWareHouseId(pageable,wareHouse);
        return wareHouseDetailsList.map(wareHouseDetailsMapper::toDto);
    }

    @Override
    public void addProductInWarehouse(WareHouseDetailsDTO wareHouseDetailsDTO) {
        WareHouseDetails wareHouseDetails = wareHouseDetailsMapper.toEntity(wareHouseDetailsDTO);
        wareHouseDetailRepository.save(wareHouseDetails);
    }

    @Override
    public void delete(Long idw, Long idp) {
        WareHouseDetailsID id = new WareHouseDetailsID(idw,idp);
        wareHouseDetailRepository.deleteById(id);
    }
}
