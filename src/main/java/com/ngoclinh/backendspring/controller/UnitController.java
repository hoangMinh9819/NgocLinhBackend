package com.ngoclinh.backendspring.controller;

import com.ngoclinh.backendspring.model.dto.UnitDTO;
import com.ngoclinh.backendspring.service.InterfaceService.IUnitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/units")
public class UnitController {
    private final IUnitService unitService;
    private static final Logger logger = LoggerFactory.getLogger(UnitController.class);
    @GetMapping(value = {"","/"})
    public ResponseEntity<List<UnitDTO>> showAll(){
        logger.info("unit's controller getAllUnitsDTO was called");
        List<UnitDTO> unitDTOList = unitService.showAll();
        logger.info("unit's service ShowAllUnitsDTO was finished");
        return ResponseEntity.ok(unitDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnitDTO> findById(@PathVariable Long id){
        UnitDTO unitDTO = unitService.findById(id);
        return ResponseEntity.ok(unitDTO);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<UnitDTO>> findByNameContaining(@RequestParam(name = "name", required = false, defaultValue = "") String name){
        List<UnitDTO> unitDTOList = unitService.findByNameContaining(name);
        return ResponseEntity.ok(unitDTOList);
    }
    @PostMapping
    public ResponseEntity<UnitDTO> add(@RequestBody @Valid UnitDTO unitDTO) {
        UnitDTO newUnit = unitService.add(unitDTO);
        return new ResponseEntity<>(newUnit, HttpStatus.CREATED);
    }


    @PutMapping
    public  ResponseEntity<UnitDTO>  updateUnit(@RequestBody UnitDTO unitDTO){
        UnitDTO updated = unitService.update(unitDTO);
        return ResponseEntity.ok(updated);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        unitService.delete(id);
    }
}
