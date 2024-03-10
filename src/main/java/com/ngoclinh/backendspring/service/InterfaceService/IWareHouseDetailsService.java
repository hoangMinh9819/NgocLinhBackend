package com.ngoclinh.backendspring.service.InterfaceService;

import com.ngoclinh.backendspring.model.dto.WareHouseDetailsDTO;
import com.ngoclinh.backendspring.model.entity.WareHouse;
import com.ngoclinh.backendspring.model.entity.WareHouseDetailsID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IWareHouseDetailsService {
    Page<WareHouseDetailsDTO> findAllById(Pageable pageable, Long id);

    void addProductInWarehouse(WareHouseDetailsDTO wareHouseDetailsDTO);
    void delete(Long idw, Long idp);
}
