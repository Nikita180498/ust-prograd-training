package com.example.Bank.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "com.example.Bank.autoGenerator.codeGenerator")
    private String accountNumber;

    private Double balance =0.0;
    @OneToOne(mappedBy = "account")
    private Customer customer;


    public Account() {
    }

    public Account(Double balance) {
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double withdraw(Double amount) {
        if(this.balance < amount){
            return balance;
        }
        else{
            return this.balance -= amount;
        }
    }

    public Double deposit(Double amount) {
        return this.balance += amount;
    }
}