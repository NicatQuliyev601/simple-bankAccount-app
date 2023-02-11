package com.nicat.bankaccount.controller;

import com.nicat.bankaccount.dto.BankAccountDto;
import com.nicat.bankaccount.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bankAccounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<BankAccountDto> transfer(@RequestParam Long fromAccountId,
                                                   @RequestParam Long toAccountId,
                                                   @RequestParam Double amount) {
        BankAccountDto bankAccountDTO = bankAccountService.transfer(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok(bankAccountDTO);
    }

    @PostMapping("/deposit")
    public ResponseEntity<BankAccountDto> deposit(@RequestParam Long accountId,
                                                  @RequestParam Double amount) {
        BankAccountDto bankAccountDTO = bankAccountService.deposit(accountId, amount);
        return ResponseEntity.ok(bankAccountDTO);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<BankAccountDto> withdraw(@RequestParam Long accountId,
                                                   @RequestParam Double amount) {
        BankAccountDto bankAccountDTO = bankAccountService.withdraw(accountId, amount);
        return ResponseEntity.ok(bankAccountDTO);
    }
}
