package com.ecommerce.paymentservice.controller;

import com.ecommerce.paymentservice.entities.MemberCardDetails;
import com.ecommerce.paymentservice.entities.PaymentTransaction;
import com.ecommerce.paymentservice.service.impl.MemberCardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/payment")
public class MemberCardDetailsController {

    @Autowired
    private MemberCardDetailsService memberCardDetailsService;

    @PostMapping(value = "/member/card/details")
    public ResponseEntity<MemberCardDetails> saveMemberCardDetails(@RequestBody MemberCardDetails memberCardDetails){
        MemberCardDetails memberCardDetail = memberCardDetailsService.saveMemberCardDetails(memberCardDetails);
        return new ResponseEntity<MemberCardDetails>(memberCardDetail, HttpStatus.OK);

    }

    @PostMapping(value = "/member/payment/transaction")
    public ResponseEntity<String> saveMemberPaymentTransaction(@RequestBody PaymentTransaction paymentTransaction){
        String  response = memberCardDetailsService.saveMemberPaymentTransaction(paymentTransaction);
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }
}
