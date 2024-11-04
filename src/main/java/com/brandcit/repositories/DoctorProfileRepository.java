package com.brandcit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.brandcit.constants.DoctorStatus;
import com.brandcit.entities.Doctors;

public interface DoctorProfileRepository extends JpaRepository<Doctors, Integer>, JpaSpecificationExecutor<Doctors> {

	List<Doctors> findBySpecialization(String specialization);

	List<Doctors> findByStatus(DoctorStatus status);

//	Optional<Doctors> searchDoctors(String keyword);

	 
}
