package com.nicat.bankaccount.service;

import com.nicat.bankaccount.dto.BankAccountDto;
import com.nicat.bankaccount.entity.BankAccount;
import com.nicat.bankaccount.mapper.BankAccountMapper;
import com.nicat.bankaccount.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    private final BankAccountMapper bankAccountMapper;

    public BankAccountDto transfer(Long fromAccountId, Long toAccountId, Double amount) {
        BankAccount fromAccount = bankAccountRepository.findById(fromAccountId).orElse(null);
        BankAccount toAccount = bankAccountRepository.findById(toAccountId).orElse(null);

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account id");
        }

        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        bankAccountRepository.save(fromAccount);
        bankAccountRepository.save(toAccount);

        return bankAccountMapper.bankAccountToBankAccountDTO(fromAccount);
    }

    public BankAccountDto deposit(Long accountId, Double amount) {
        BankAccount account = bankAccountRepository.findById(accountId).orElse(null);
        if (account == null) {
            throw new IllegalArgumentException("Invalid account id");
        }
        account.setBalance(account.getBalance() + amount);
        account = bankAccountRepository.save(account);
        return bankAccountMapper.bankAccountToBankAccountDTO(account);
    }

    public BankAccountDto withdraw(Long accountId, Double amount) {
        BankAccount account = bankAccountRepository.findById(accountId).orElse(null);
        if (account == null) {
            throw new IllegalArgumentException("Invalid account id");
        }
        if (account.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        account = bankAccountRepository.save(account);
        return bankAccountMapper.bankAccountToBankAccountDTO(account);
    }
}
