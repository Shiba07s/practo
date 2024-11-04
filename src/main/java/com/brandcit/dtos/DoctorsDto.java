package com.brandcit.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.brandcit.constants.DoctorStatus;
import com.brandcit.entities.Appointment;
import com.brandcit.entities.AvailabilitySlot;
import com.brandcit.entities.Prescription;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorsDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String registrationNumber;
	private String yearOfRegistration;
	private String councilName;
	private String specialization;
	private String qualification;
	private Integer yearsOfExperience;
	private String clinicName;
	private String clinicAddress;
	private String clinicLocation;
	private BigDecimal consultationFee;
	private String letterheadFormat; // Path to the stored letterhead file
	private String bankAccountNumber;
	private String ifscCode;
	
    @JsonFormat(pattern = "MMM dd yyyy hh:mm a")  // Will output like "Oct 27, 2024 10:44 PM"
	private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "MMM dd yyyy hh:mm a")  // Will output like "Oct 27, 2024 10:44 PM"
	private LocalDateTime updatedAt;
	private DoctorStatus status;
	private List<Appointment> appointments;
	private List<AvailabilitySlot> availabilitySlots;
//	private List<Prescription> prescriptions;

}
