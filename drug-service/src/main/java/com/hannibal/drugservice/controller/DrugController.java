package com.hannibal.drugservice.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hannibal.drugservice.model.Drug;
import com.hannibal.drugservice.service.DrugService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("/api/drugs/")
@RequiredArgsConstructor
public class DrugController {
    
    @Autowired
    private DrugService drugService;

    @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all-drugs")
    public List<Drug> getAllDrugs(){
		return drugService.getAllDrugs();
	}

    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Drug createPatient(@RequestBody Drug drug) {
		return drugService.createDrug(drug);
	}

    @GetMapping("/{id}")
	public ResponseEntity<Drug> getDrugById(@PathVariable Long id) throws AttributeNotFoundException {
		
		return drugService.getDrugById(id);
	}

    @PutMapping("/{id}")
    public ResponseEntity<Drug> updateDrug(@PathVariable Long id, @RequestBody Drug drug) {
        
        return ResponseEntity.ok(drugService.updateDrug(id, drug));
    }

    @DeleteMapping("/{id}")
    public void deleteDrug(@PathVariable Long id) {
        drugService.deleteDrug(id);
    }


}
