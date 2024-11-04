package com.brandcit.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.brandcit.entities.Appointment;
import com.brandcit.entities.Prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private LocalDate dateOfBirth;
	private String gender;
	private String bloodGroup;
	private String height;
	private String weight;
	private String emergencyContact;
	private String medicalHistory;
	private String allergies;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<Appointment> appointments;
//	private List<Prescription> prescriptions;

}