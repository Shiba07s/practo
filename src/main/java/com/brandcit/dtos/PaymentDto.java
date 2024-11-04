package com.brandcit.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.brandcit.constants.PaymentStatus;
import com.brandcit.constants.RefundStatus;
import com.brandcit.entities.Appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

	private Integer id;
	private Appointment appointment;
	private LocalDateTime paymentDate;
	private BigDecimal amount;
	private String transactionId;
	private String paymentGateway;
	private PaymentStatus status;
	private String paymentMethod;
	private RefundStatus refundStatus;
	private BigDecimal refundAmount;
	private LocalDateTime refundDate;
}