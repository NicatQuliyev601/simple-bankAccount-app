package com.nicat.bankaccount.config;

import com.nicat.bankaccount.dto.BankAccountDto;
import com.nicat.bankaccount.entity.BankAccount;
import com.nicat.bankaccount.mapper.BankAccountMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankAccountConfig {
    @Bean
    public BankAccountMapper bankAccountMapper() {
        return new BankAccountMapper() {
            @Override
            public BankAccountDto bankAccountToBankAccountDTO(BankAccount bankAccount) {
                return null;
            }

            @Override
            public BankAccount bankAccountDTOToBankAccount(BankAccountDto bankAccountDTO) {
                return null;
            }
        };
    }
}