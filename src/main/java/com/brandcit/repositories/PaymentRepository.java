package com.brandcit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brandcit.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	 
}
