package com.example.Bank.repository;


import com.example.Bank.entity.Account;
import com.example.Bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("Select account from Account account where account.accountNumber=:accountNumber")
    Account findByAccountNumber(String accountNumber);

    @Query("Select account from Account account where account.customer=:customer")
    Account findByAccountNumber(Customer customer);
}