package com.ngoclinh.backendspring.controller;

import com.ngoclinh.backendspring.model.dto.UnitDTO;
import com.ngoclinh.backendspring.service.InterfaceService.IUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/units")
public class UnitController {
    private final IUnitService unitService;
    @GetMapping(value = {"","/"})
    public ResponseEntity<List<UnitDTO>> getAllUnitsDTO(){
        List<UnitDTO> unitDTOList = unitService.showAllUnitsDTO();
        return new ResponseEntity<>(unitDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnitDTO> findById(@PathVariable Long id){
        UnitDTO unitDTO = unitService.findById(id);
        return new ResponseEntity<>(unitDTO,HttpStatus.OK);
    }
//
//    @GetMapping(value = "/search")
//    public UnitDTO findByName(@RequestParam(value = "keyword", required = false, defaultValue = "") String name){
//        return unitService.findByName(name);
//    }
//
//    @PostMapping("")
//    public void addUnit(@RequestBody UnitDTO unitDTO){
//        unitService.addUnit(unitDTO);
//    }
//
//    @PutMapping("")
//    public void updateUnit(@RequestBody UnitDTO unitDTO){ unitService.updateUnit(unitDTO);}
//
//    @DeleteMapping("/deleteUnit/{id}")
//    public void deleteById(@PathVariable Long id){
//        unitService.deleteUnit(id);
//    }
}
