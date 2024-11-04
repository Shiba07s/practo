package com.brandcit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandcit.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	 
}
