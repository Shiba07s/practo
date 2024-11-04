package com.brandcit.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import com.brandcit.constants.PaymentStatus;
import com.brandcit.constants.RefundStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @NotNull
    private BigDecimal amount;

    @Column(name = "transaction_id")
    private String transactionId;
    
    private String paymentGateway; // e.g., Razorpay, PayU, etc.


    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "refund_status")
    @Enumerated(EnumType.STRING)
    private RefundStatus refundStatus;

    @Column(name = "refund_amount")
    private BigDecimal refundAmount;

    @Column(name = "refund_date")
    private LocalDateTime refundDate;
}