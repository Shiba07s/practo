package com.brandcit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandcit.entities.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	 
}
