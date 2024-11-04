package com.brandcit.dtos;

import com.brandcit.entities.Prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineDto {

	private Integer id;
	private Prescription prescription;
	private String name;
	private String dosage;
	private String frequency;
	private String duration;
	private String instructions;
}
