package com.ngoclinh.backendspring.controller;

import com.ngoclinh.backendspring.dto.UnitDTO;
import com.ngoclinh.backendspring.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UnitController {

    @Autowired
    private UnitService unitService;
    @GetMapping("/units")
    public List<UnitDTO> getAllUnits(){
        return unitService.showAllUnits();
    }

    @GetMapping("/unitById/{id}")
    public UnitDTO findById(@PathVariable Long id){
        return unitService.findById(id);
    }

    @GetMapping("/unitByName/{name}")
    public UnitDTO findByName(@PathVariable String name){
        return unitService.findByName(name);
    }

    @PostMapping("/addUnit")
    public void addUnit(@RequestBody UnitDTO unitDTO){
        unitService.addUnit(unitDTO);
    }

    @DeleteMapping("/deleteUnit/{id}")
    public void deleteById(@PathVariable Long id){
        unitService.deleteUnit(id);
    }

    @PutMapping("/updateUnit")
    public void updateUnit(@RequestBody UnitDTO unitDTO){ unitService.updateUnit(unitDTO);}
}
