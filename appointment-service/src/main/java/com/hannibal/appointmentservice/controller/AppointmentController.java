package com.hannibal.appointmentservice.controller;


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

import com.hannibal.appointmentservice.model.Appointment;
import com.hannibal.appointmentservice.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(allowedHeaders = "*",origins = "*")
@RequestMapping("/api/appointments/")
@RequiredArgsConstructor
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all-appointments")
    public List<Appointment> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}

    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create")
	public Appointment createPatient(@RequestBody Appointment appointment) {
		return appointmentService.createAppointment(appointment);
	}

    @GetMapping("/{id}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) throws AttributeNotFoundException {
		
		return appointmentService.getAppointmentById(id);
	}

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        
        return ResponseEntity.ok(appointmentService.updateAppointment(id, appointment));
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }
    
}
