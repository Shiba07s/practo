package com.brandcit.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.brandcit.constants.AppointmentStatus;
import com.brandcit.constants.ConsultationType;
import com.brandcit.entities.Doctors;
import com.brandcit.entities.Patient;
import com.brandcit.entities.Payment;
import com.brandcit.entities.Prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

	private Integer id;
	private LocalDateTime appointmentDate;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String consultationLink;
	private BigDecimal consultationFee;
	private Payment payment;
	private String cancellationReason;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private AppointmentStatus status; // BOOKED, CANCELLED, COMPLETED
	private ConsultationType consultationType;

	private Doctors doctors;
	private Patient patient;
	private Prescription prescription;

}