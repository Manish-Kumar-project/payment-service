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
        if(memberCardDetails.getCardNumber().longValue() == paymentTransaction.getCardNumber().longValue() && memberCardDetails.getCardCvv().intValue() == paymentTransaction.getCardCvv().intValue() && memberCardDetails.getCardExpiry().intValue()==paymentTransaction.getCardExpiry().intValue()){
           if(memberCardDetails.getCardBalance()<paymentTransaction.getTransactionAmount()){
               response = "insufficient balance";
           }else{
               paymentTransaction.setResponseMessage("transaction_success");
               paymentTransactionRepository.save(paymentTransaction);
               response = "payment_successful";
           }
        }else{
            System.out.println("Invalid Member Card Details");
            response = "transaction_failed";
        }
        return response;
    }
}
