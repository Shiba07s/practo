package com.brandcit.request;

import java.math.BigDecimal;

import com.brandcit.constants.DoctorStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorSearchCriteria {
    private String keyword;
    private String specialization;
    private String location;
    private String clinicName;
    private Integer minExperience;
    private BigDecimal maxFee;
    private DoctorStatus status;
}