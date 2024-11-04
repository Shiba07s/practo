package com.brandcit.dtos;

import java.time.LocalDateTime;

import com.brandcit.entities.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoConsultationDto {
    private Integer id;
    private Appointment appointment;
    private String videoLink; // Agora video consultation link
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
