package com.brandcit.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AvailabilityStatus {
	AVAILABLE("Available"),
	BOOKED("Booked"),
	BLOCKED("Blocked");

	private final String displayName;
}