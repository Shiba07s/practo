package com.brandcit.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brandcit.constants.DoctorStatus;
import com.brandcit.dtos.DoctorsDto;
import com.brandcit.request.DoctorSearchCriteria;
import com.brandcit.services.DoctorProfileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/doctor-profile")
public class DoctorProfileController {

	private final DoctorProfileService doctorProfileService;

	// Create a new doctor profile
	@PostMapping("/create")
	public ResponseEntity<DoctorsDto> createDoctorsProfile(@RequestBody DoctorsDto doctorsDto) {
		DoctorsDto doctor = doctorProfileService.createDoctor(doctorsDto);
		return new ResponseEntity<>(doctor, HttpStatus.CREATED);
	}

	// Get the list of all doctors
	@GetMapping
	public ResponseEntity<List<DoctorsDto>> getDoctorsList() {
		List<DoctorsDto> allDoctors = doctorProfileService.getAllDoctors();
		return new ResponseEntity<>(allDoctors, HttpStatus.OK);
	}

	// Update a doctor profile by ID
	@PutMapping("/update/{id}")
	public ResponseEntity<DoctorsDto> updateDoctor(@PathVariable Integer id,
			@Validated @RequestBody DoctorsDto doctorDto) {
		DoctorsDto updatedDoctor = doctorProfileService.updateDoctor(id, doctorDto);
		return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
	}

	// Get a doctor profile by ID
	@GetMapping("/{id}")
	public ResponseEntity<DoctorsDto> getDoctorById(@PathVariable Integer id) {
		DoctorsDto getById = doctorProfileService.getDoctorById(id);
		return new ResponseEntity<>(getById, HttpStatus.OK);
	}

	// Delete a doctor profile by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id) {
		doctorProfileService.deleteDoctor(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Get doctors by specialization
	@GetMapping("/specialization/{specialization}")
	public ResponseEntity<List<DoctorsDto>> getDoctorsBySpecialization(@PathVariable String specialization) {
		List<DoctorsDto> doctorsBySpecialization = doctorProfileService.getDoctorsBySpecialization(specialization);
		return new ResponseEntity<>(doctorsBySpecialization, HttpStatus.OK);
	}

	// Get doctors by status
	@GetMapping("/status/{status}")
	public ResponseEntity<List<DoctorsDto>> getDoctorsByStatus(@PathVariable DoctorStatus status) {
		List<DoctorsDto> doctorsByStatus = doctorProfileService.getDoctorsByStatus(status);
		return new ResponseEntity<>(doctorsByStatus, HttpStatus.OK);
	}

//    @GetMapping("/search")
//    public ResponseEntity<List<DoctorsDto>> searchDoctors(@RequestParam String keyword) {
//        List<DoctorsDto> doctors = doctorProfileService.searchDoctors(keyword);
//        return new ResponseEntity<>(doctors, HttpStatus.OK);
//    }

	@GetMapping("/search")
    public ResponseEntity<List<DoctorsDto>> searchDoctors(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String clinicName,
            @RequestParam(required = false) Integer minExperience,
            @RequestParam(required = false) BigDecimal maxFee,
            @RequestParam(required = false) DoctorStatus status) {

        DoctorSearchCriteria criteria = DoctorSearchCriteria.builder()
                .keyword(keyword)
                .specialization(specialization)
                .location(location)
                .clinicName(clinicName)
                .minExperience(minExperience)
                .maxFee(maxFee)
                .status(status)
                .build();

        List<DoctorsDto> doctors = doctorProfileService.searchDoctors(criteria);
        return ResponseEntity.ok(doctors);
    }
}