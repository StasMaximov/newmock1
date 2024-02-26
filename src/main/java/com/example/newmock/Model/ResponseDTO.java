package com.example.newmock.Model;

import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ResponseDTO {

    private String rqUID;
    private String clientId;
    private String account;
    private String currency;
    private int balance;
    private BigDecimal maxLimit;
}
