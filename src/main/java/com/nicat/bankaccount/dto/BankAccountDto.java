package com.nicat.bankaccount.dto;

import lombok.Data;

@Data
public class BankAccountDto {
    private Long id;
    private String accountNumber;
    private Double balance;
}
