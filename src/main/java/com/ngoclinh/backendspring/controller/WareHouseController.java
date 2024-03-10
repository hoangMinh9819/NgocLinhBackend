package com.ngoclinh.backendspring.controller;

import com.ngoclinh.backendspring.model.dto.WareHouseDTO;
import com.ngoclinh.backendspring.model.dto.WareHouseDetailsDTO;
import com.ngoclinh.backendspring.model.entity.WareHouseDetailsID;
import com.ngoclinh.backendspring.service.InterfaceService.IWareHouseDetailsService;
import com.ngoclinh.backendspring.service.InterfaceService.IWareHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouses")
public class WareHouseController {
    private final IWareHouseService iWareHouseService;
    private final IWareHouseDetailsService iWareHouseDetailsService;
    @GetMapping(value = {"","/"})
    public ResponseEntity<List<WareHouseDTO>> showAll(){
        List<WareHouseDTO> wareHouseDTOS = iWareHouseService.findAll();
        return ResponseEntity.ok(wareHouseDTOS);
    }
    @GetMapping("/{id}")
    public Page<WareHouseDetailsDTO> getAllProductsByWarehouseId(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return iWareHouseDetailsService.findAllById(pageable,id);
    }
    @PostMapping()
    public String addProductInWarehouse(@RequestBody WareHouseDetailsDTO wareHouseDetailsDTO){
        iWareHouseDetailsService.addProductInWarehouse(wareHouseDetailsDTO);
        return "Create successful";
    }
    @DeleteMapping("/{idw}/{idp}")
    public void deleteById(@PathVariable Long idw, @PathVariable Long idp){
        iWareHouseDetailsService.delete(idw,idp);
    }
}
