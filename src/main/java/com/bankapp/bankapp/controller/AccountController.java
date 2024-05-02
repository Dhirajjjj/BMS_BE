package com.bankapp.bankapp.controller;

import com.bankapp.bankapp.model.Account;
import com.bankapp.bankapp.model.Transaction;
import com.bankapp.bankapp.service.AccountService;
import com.bankapp.bankapp.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AccountController {


   @Autowired
   private AccountService accountService;
   @Autowired
   private TransactionService transactionService;


  // insert a product into database
   @PostMapping("/account")
   public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
     Account savedAccount = accountService.saveAccount(account);
     return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
   }


  //get a single product by its id
   @GetMapping("/account")
   public ResponseEntity<Account> getAccount(@RequestParam(name = "accountId") long accountId) {
       Account account = accountService.getAccount(accountId);
       return new ResponseEntity<>(account, HttpStatus.OK);
   }
   
   
 //get a account balance by its id
   @GetMapping("/account/balance")
   public ResponseEntity<Account> getAccountBalance(@RequestParam(name = "accountId") long accountId) {
       Account account = accountService.getAccount(accountId);
       return new ResponseEntity<>(account, HttpStatus.OK);
   }


   //get all the products in the table in our database
   @GetMapping("/account/all")
   public List<Account> getAccount() {
       return accountService.getAccount();
   }


   //update an existing product in the database
   @PatchMapping("/account")
   public ResponseEntity<Account> updateAccount(@RequestParam(name ="accountId") long accountId, @RequestBody Account account) {
       Account updatedAccount = accountService.updateAccount(accountId, account);
       return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
   }
   
   
   @PostMapping("/account/deposit")
   public ResponseEntity<Account> updateAccountDeposit(@RequestParam(name ="accountId") long accountId, @RequestParam(name ="amount") double depositAmount, @RequestBody Account account) {
       Account updatedAccount = accountService.updateAccountDeposit(accountId, depositAmount, account);
       
       Transaction transaction = new Transaction();
       transaction.setAccountId(accountId);
       transaction.setType("credit");
       transaction.setAmount(depositAmount);
       Transaction savedTransaction = transactionService.saveTransaction(transaction);
       
       return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
   }
   
   
   @PostMapping("/account/withdraw")
   public ResponseEntity<Account> updateAccountWithdraw(@RequestParam(name ="accountId") long accountId, @RequestParam(name ="amount") double withdrawAmount, @RequestBody Account account) {
       Account updatedAccount = accountService.updateAccountWithdraw(accountId, withdrawAmount, account);
       
       Transaction transaction = new Transaction();
       transaction.setAccountId(accountId);
       transaction.setType("debit");
       transaction.setAmount(withdrawAmount);
       Transaction savedTransaction = transactionService.saveTransaction(transaction);
       
       return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
   }


   // delete an existing product in the database
   @DeleteMapping("/account")
   public ResponseEntity<Account> deleteAccount(@RequestParam(name ="accountId") long accountId) {
       Account deletedAccount = accountService.deleteaccount(accountId);
       return new ResponseEntity<>(deletedAccount, HttpStatus.OK);
   }


   // get product by name using a raw SQL statement
   @GetMapping("/account-by-holder-id")
   public List<Account> getAccountById(@RequestParam(name ="accountId") long accountId) {
       return accountService.getAccountById(accountId);
   }  
}

 
