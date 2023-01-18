package com.hannibal.appointmentservice.service;


import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hannibal.appointmentservice.model.Appointment;
import com.hannibal.appointmentservice.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public ResponseEntity<Appointment> getAppointmentById(Long id) throws AttributeNotFoundException {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Appointment Not Found!: " + id));

        return ResponseEntity.ok(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment appointment){

        Appointment oldAppointment = appointmentRepository.findById(id).get();

        oldAppointment.setId(appointment.getId());
        oldAppointment.setAge((appointment.getAge()));
        oldAppointment.setName(appointment.getName());
        oldAppointment.setNumber(appointment.getNumber());
        oldAppointment.setSymptoms(appointment.getSymptoms());


        return appointmentRepository.save(oldAppointment);

    }

    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }
    
}
