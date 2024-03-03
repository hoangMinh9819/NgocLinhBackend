package com.ngoclinh.backendspring.service.InterfaceService;

import com.ngoclinh.backendspring.model.dto.WareHouseDTO;

import java.util.List;

public interface IWareHouseService {
    List<WareHouseDTO> findAll();
}
