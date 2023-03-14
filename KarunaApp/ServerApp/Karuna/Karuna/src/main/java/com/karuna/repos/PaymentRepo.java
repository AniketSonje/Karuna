package com.karuna.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karuna.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
