package com.ngoclinh.backendspring.controller;

import com.ngoclinh.backendspring.model.dto.UnitDTO;
import com.ngoclinh.backendspring.model.dto.WareHouseDTO;
import com.ngoclinh.backendspring.service.InterfaceService.IUnitService;
import com.ngoclinh.backendspring.service.InterfaceService.IWareHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/warehouses")
public class WareHouseController {
    private final IWareHouseService iWareHouseService;
    @GetMapping(value = {"","/"})
    public ResponseEntity<List<WareHouseDTO>> showAll(){
        List<WareHouseDTO> wareHouseDTOS = iWareHouseService.findAll();
        return ResponseEntity.ok(wareHouseDTOS);
    }
}
