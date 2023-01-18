package com.hannibal.appointmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hannibal.appointmentservice.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
