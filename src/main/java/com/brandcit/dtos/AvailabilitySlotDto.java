package com.brandcit.dtos;

import java.time.LocalDateTime;

import com.brandcit.constants.AvailabilityStatus;
import com.brandcit.constants.SlotFrequency;
import com.brandcit.entities.Doctors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilitySlotDto {

	private Integer id;
	private Doctors doctors;
	private LocalDateTime date;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Integer slotDuration;
	private AvailabilityStatus status;
	private SlotFrequency frequency;

}
