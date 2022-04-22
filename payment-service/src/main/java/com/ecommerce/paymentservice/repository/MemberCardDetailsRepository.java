package com.ecommerce.paymentservice.repository;

import com.ecommerce.paymentservice.entities.MemberCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCardDetailsRepository extends JpaRepository<MemberCardDetails,Long> {

    MemberCardDetails findByCardNumber(Long cardNumber);
}
