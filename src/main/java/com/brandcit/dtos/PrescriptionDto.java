package com.brandcit.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.brandcit.entities.Appointment;
import com.brandcit.entities.Medicine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {
	
    private Integer id;
    private Appointment appointment;
    private LocalDateTime prescriptionDate;
    private String symptoms;
    private String diagnosis;
    private List<Medicine> medicines = new ArrayList<>();
    private String advice;
    private LocalDateTime followUpDate;
    private String prescriptionUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
