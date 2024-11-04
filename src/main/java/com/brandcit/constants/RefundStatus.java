package com.brandcit.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RefundStatus {
    NOT_APPLICABLE("Not Applicable"),
    PENDING("Pending"),
    PROCESSED("Processed"),
    FAILED("Failed");

    private final String displayName;
}
