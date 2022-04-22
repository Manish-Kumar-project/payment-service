package com.ecommerce.paymentservice.service.impl;

import com.ecommerce.paymentservice.entities.MemberCardDetails;
import com.ecommerce.paymentservice.entities.PaymentTransaction;
import com.ecommerce.paymentservice.repository.MemberCardDetailsRepository;
import com.ecommerce.paymentservice.repository.PaymentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberCardDetailsService {

    @Autowired
    private MemberCardDetailsRepository memberCardDetailsRepository;

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;
    public MemberCardDetails saveMemberCardDetails(MemberCardDetails memberCardDetails) {
       return  memberCardDetailsRepository.save(memberCardDetails);
    }

    public String saveMemberPaymentTransaction(PaymentTransaction paymentTransaction) {
        String response = null;
        MemberCardDetails memberCardDetails = memberCardDetailsRepository.findByCardNumber(paymentTransaction.getCardNumber());
        if(memberCardDetails.getCardNumber() == paymentTransaction.getCardNumber() && memberCardDetails.getCardCvv() == paymentTransaction.getCardCvv() && memberCardDetails.getCardCvv()==paymentTransaction.getCardCvv()){
           if(memberCardDetails.getCardBalance()<paymentTransaction.getTransactionAmount()){
               response = "insufficient balance";
           }else{
               paymentTransactionRepository.save(paymentTransaction);
               response = "transaction_success";
           }
        }else{
            System.out.println("Invalid Member Card Details");
            response = "transaction_failed";
        }
        return response;
    }
}
