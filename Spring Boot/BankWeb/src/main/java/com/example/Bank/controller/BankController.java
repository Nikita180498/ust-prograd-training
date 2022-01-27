package com.example.Bank.controller;
import com.example.Bank.entity.Account;
import com.example.Bank.entity.Customer;
import com.example.Bank.service.AccountService;
import com.example.Bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BankController {

    @Autowired
    private CustomerService service;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/")
    public String index(){
        return "Home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/customerList")
    @ResponseBody
    public List<Customer> list() {
        return service.listAll();
    }


    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request){
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        Customer customer;
        if (service.existsById(username) == true) {
            customer = service.findById(username);
            if (password.equals(customer.getPassword())) {
                model.addAttribute("customerName", customer.getCustomerName());
                model.addAttribute("userName", customer.getUserName());
                model.addAttribute("Email", customer.getEmail());
                model.addAttribute("Address", customer.getAddress());
                model.addAttribute("Contact", customer.getContact());
                model.addAttribute("accountNumber", customer.getAccount().getAccountNumber());
                model.addAttribute("balance", customer.getAccount().getBalance());
                return "afterlogin";

            } else {
                model.addAttribute("errorMessage", "Incorrect Password.");
                return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Please enter valid Username");
            return "login";
        }
    }

    @RequestMapping("/afterlogin")
    public String afterlogin(){
        return "afterlogin";
    }

    @RequestMapping("/customerDetails/{id}")
    public String customerDetails(@PathVariable String id, Model model){
        model.addAttribute("userName",id);
        Customer customer = service.findById(id);
        model.addAttribute("password",customer.getPassword());
        model.addAttribute("customerName",customer.getCustomerName());
        model.addAttribute("Contact",customer.getContact());
        model.addAttribute("Email",customer.getEmail());
        model.addAttribute("Address",customer.getAddress());
        model.addAttribute("accountNumber",customer.getAccount().getAccountNumber());
        model.addAttribute("balance",customer.getAccount().getBalance());

        return "customerDetails";
    }

    @RequestMapping("/accountDetails/{id}")
    public String accountDetails(@PathVariable String id, Model model){
        model.addAttribute("accountNumber",id);
        Account account = accountService.getById(id);
        model.addAttribute("accountNumber",account.getAccountNumber());
        model.addAttribute("balance",account.getBalance());

        return "accountDetails";
    }



    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String register(Model model, HttpServletRequest request){
        String name = request.getParameter("customerName");
        String  username = request.getParameter("userName");
        String contact = request.getParameter("Contact");
        String  email = request.getParameter("Email");
        String  address = request.getParameter("Address");
        String password = request.getParameter("Password");

        Account account = accountService.saveAccount(new Account());
        Customer customer = new Customer(name,username,contact,email,address,password);
        customer.setAccount(account);
        service.saveCustomer(customer);
        model.addAttribute("registerSuccessMessage", "Registered Successfully!!");
        return "login";
    }

    @RequestMapping("/fundTransfer/{accountNumber}")
    public String transfer(@PathVariable String accountNumber, Model model){
        model.addAttribute("accountNumber", accountNumber);
        return "fundTransfer";
    }

    @PostMapping("/fundTransfer/{accountNumber}")
    public String fundTransfer(@PathVariable String accountNumber, Model model, HttpServletRequest request){

        String toAccount = request.getParameter("toAccount");
        Double amount = Double.parseDouble(request.getParameter("amount"));


        if (accountService.existAccount(toAccount)) {
            Account account1 = accountService.getById(accountNumber);
            Account account2 = accountService.getById(toAccount);
            if (account1.getBalance() <= amount) {
                model.addAttribute("message", "insufficient Amount in your Account");
            } else {
                account1.withdraw(amount);
                account2.deposit(amount);
                accountService.saveAccount(account1);
                accountService.saveAccount(account2);
                model.addAttribute("message", "Transaction done successfully");
            }
        }
        else {
            model.addAttribute("message", "Account does not Exist! Please Enter valid Account Number");
        }

        return "fundTransfer";
    }


    @RequestMapping("/updateDetails/{id}")
    public String updateDetailsForm(@PathVariable String id, Model model){
        model.addAttribute("customer",service.findById(id));
        return "updateDetails";
    }


    @PostMapping("/updateDetails")
    public String updateDetails(Model model,HttpServletRequest request){

        Customer existingCustomer = service.findById(request.getParameter("userName"));
        existingCustomer.setCustomerName(request.getParameter("customerName"));
        existingCustomer.setContact(request.getParameter("Contact"));
        existingCustomer.setEmail(request.getParameter("Email"));
        existingCustomer.setAddress(request.getParameter("Address"));

        service.updateCustomer(existingCustomer);

        model.addAttribute("customerName", existingCustomer.getCustomerName());
        model.addAttribute("userName", existingCustomer.getUserName());
        model.addAttribute("Email", existingCustomer.getEmail());
        model.addAttribute("Address", existingCustomer.getAddress());
        model.addAttribute("Contact", existingCustomer.getContact());
        model.addAttribute("accountNumber",existingCustomer.getAccount().getAccountNumber());
        model.addAttribute("balance",existingCustomer.getAccount().getBalance());

        model.addAttribute("message", "Updated successfully");

        return "afterlogin";
    }


    @RequestMapping("/deposit/{accountNumber}")
    public String depositForm(@PathVariable String accountNumber, Model model) {
        model.addAttribute("accountNumber",accountNumber);
        return "deposit";
    }

    @PostMapping("/deposit/{accountNumber}")
    public String deposit(@PathVariable String accountNumber, HttpServletRequest request, Model model) {
        Account account = accountService.getById(accountNumber);
        Double amount = Double.parseDouble(request.getParameter("amount"));
        account.deposit(amount);
        accountService.saveAccount(account);
        model.addAttribute("message", "Deposited successfully");
        return "deposit";
    }

    @GetMapping("/withdraw/{accountNumber}")
    public String withdrawForm(@PathVariable String accountNumber, Model model) {
        model.addAttribute("accountNumber", accountNumber);
        return "withdraw";
    }

    @PostMapping("/withdraw/{accountNumber}")
    public String withdraw(@PathVariable String accountNumber, HttpServletRequest request, Model model) {
        Double amount = Double.parseDouble(request.getParameter("amount"));
        Account account = accountService.getById(accountNumber);
        if (account.getBalance() <= amount) {
            model.addAttribute("message", "insufficient Amount");
        } else {
            account.withdraw(amount);
            accountService.saveAccount(account);
            model.addAttribute("message", "Withdraw successfully");
        }
        return "withdraw";
    }

}