package com.brandcit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandcit.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	 
}
