package com.brandcit.entities;

import java.time.LocalDateTime;


import com.brandcit.constants.AvailabilityStatus;
import com.brandcit.constants.SlotFrequency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="availability_slot")
public class AvailabilitySlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctors doctors;


    @NotNull
    @Column(name = "date")
    private LocalDateTime date;

    @NotNull
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @NotNull
    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "slot_duration")
    private Integer slotDuration;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus status;

    @Enumerated(EnumType.STRING)
    private SlotFrequency frequency;  // DAILY, WEEKLY, MONTHLY

    // Getters and Setters
}
