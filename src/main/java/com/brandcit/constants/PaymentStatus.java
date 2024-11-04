package com.brandcit.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
	    PENDING("Pending"),
	    COMPLETED("Completed"),
	    REFUNDED("Refunded");

	    private final String displayName;
	    
}