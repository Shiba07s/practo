package com.brandcit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandcit.entities.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

	 
}
