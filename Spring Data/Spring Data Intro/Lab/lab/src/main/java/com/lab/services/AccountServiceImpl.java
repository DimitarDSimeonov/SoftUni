package com.lab.services;

import com.lab.entities.Account;
import com.lab.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account is not found"));

        if (account.getBalance().compareTo(money) >= 0) {
            account.setBalance(account.getBalance().subtract(money));
            accountRepository.save(account);
        } else {
            throw new IllegalArgumentException("You not enough money");
        }
    }

    @Override
    public void depositMoney(BigDecimal money, Long id) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account is not found"));

            account.setBalance(account.getBalance().add(money));
            accountRepository.save(account);
    }
}
