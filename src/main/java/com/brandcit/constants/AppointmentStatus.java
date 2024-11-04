package com.brandcit.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppointmentStatus {
    BOOKED("Booked"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed");

    private final String displayName;
 
}
