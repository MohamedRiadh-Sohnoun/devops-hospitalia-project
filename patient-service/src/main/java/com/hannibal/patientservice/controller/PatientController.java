package com.hannibal.patientservice.controller;

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

import com.hannibal.patientservice.model.Patient;
import com.hannibal.patientservice.service.PatientService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("/api/patients/")
@RequiredArgsConstructor
public class PatientController {
    
    @Autowired
    private PatientService patientService;

    @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all-patients")
    public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}


    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}


    @GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws AttributeNotFoundException {
		
		return patientService.getPatientById(id);
	}

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient newPatient) throws AttributeNotFoundException{
        
        return ResponseEntity.ok(patientService.updatePatient(id, newPatient));
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) throws AttributeNotFoundException{
        patientService.deletePatient(id);
    }
}
