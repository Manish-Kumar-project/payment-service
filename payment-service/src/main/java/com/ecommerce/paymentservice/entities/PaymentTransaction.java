package com.ecommerce.paymentservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment_transaction")
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "transaction_id",  nullable = false,unique = true)
    private String transactionId;

    @Column(name = "transaction_amount", nullable = false)
    private String transactionAmount;

    @Column(name = "card_number", nullable = false)
    private Double cardNumber;


    @Column(name = "card_expiry", nullable = false)
    private Integer cardExpiry;

    @Column(name = "card_cvv", nullable = false)
    private Integer cardCvv;

    @Column(name = "card_brand", nullable = false)
    private Integer cardBrand;

    @Column(name = "card_type", nullable = false)
    private Integer cardType;

    @Column(name = "card_balance", nullable = false)
    private Integer cardBalance;

}
