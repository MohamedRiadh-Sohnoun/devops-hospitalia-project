package com.hannibal.drugservice.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hannibal.drugservice.model.Drug;
import com.hannibal.drugservice.repository.DrugRepository;

@Service
public class DrugService {
    
    @Autowired
    private DrugRepository drugRepository;

    public Drug createDrug(Drug drug){
        return drugRepository.save(drug);
    }

    public List<Drug> getAllDrugs(){
        return drugRepository.findAll();
    }

    public ResponseEntity<Drug> getDrugById(Long id) throws AttributeNotFoundException {
        Drug drug = drugRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Drug Not Found!: " + id));

        return ResponseEntity.ok(drug);
    }

    public Drug updateDrug(Long id, Drug drug){

        Drug oldDrug = drugRepository.findById(id).get();

        oldDrug.setId(drug.getId());
        oldDrug.setDrugName((drug.getDrugName()));
        oldDrug.setStock(drug.getStock());

        return drugRepository.save(oldDrug);

    }

    public void deleteDrug(Long id){
        drugRepository.deleteById(id);
    }
}
