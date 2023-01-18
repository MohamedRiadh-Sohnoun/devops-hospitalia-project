package com.hannibal.patientservice.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hannibal.patientservice.model.Patient;
import com.hannibal.patientservice.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}

    public ResponseEntity<Patient> getPatientById(Long id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient Not Found!: " + id));

        return ResponseEntity.ok(patient);
    }

    public Patient updatePatient(Long id, Patient newPatient) {

        Patient oldPatient = patientRepository.findById(id).get();

        oldPatient.setAge(newPatient.getAge());
        oldPatient.setName(newPatient.getName());
        oldPatient.setBloodType(newPatient.getBloodType());
        oldPatient.setDose(newPatient.getDose());
        oldPatient.setFees(newPatient.getFees());
        oldPatient.setUrgency(newPatient.getUrgency());

        oldPatient.setId(newPatient.getId());

        return patientRepository.save(oldPatient);

    }

    public void deletePatient(Long id) throws AttributeNotFoundException {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient Not Found!: " + id));

        patientRepository.delete(patient);


    }

}
