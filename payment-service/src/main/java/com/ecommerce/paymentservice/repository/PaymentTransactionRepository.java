package com.ecommerce.paymentservice.repository;

import com.ecommerce.paymentservice.entities.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction,Long> {
}
