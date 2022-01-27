package com.example.Bank.service;

import com.example.Bank.entity.Account;
import com.example.Bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> accountList() {
        return accountRepository.findAll();
    }

    public Account getById(String accountNumber){
        return accountRepository.findById(accountNumber).get();
    }

    public Boolean existAccount(String accountNumber){
        return accountRepository.existsById(accountNumber);
    }
}