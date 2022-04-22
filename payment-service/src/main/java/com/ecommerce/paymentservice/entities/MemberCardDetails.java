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
@Table(name = "card_details")
public class MemberCardDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "card_number",nullable = false,unique = true)
    private Long cardNumber;


    @Column(name = "card_expiry", nullable = false,unique = true)
    private Integer cardExpiry;

    @Column(name = "card_cvv", nullable = false,unique = true)
    private Integer cardCvv;

    @Column(name = "card_brand", nullable = false)
    private Integer cardBrand;

    @Column(name = "card_type", nullable = false)
    private Integer cardType;

    @Column(name = "card_balance", nullable = false)
    private Double cardBalance;


}
