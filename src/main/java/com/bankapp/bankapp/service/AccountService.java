package com.bankapp.bankapp.service;


import com.bankapp.bankapp.model.Account;
import com.bankapp.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class AccountService {


   @Autowired
   private AccountRepository accountRepository;


   public Account saveAccount(Account account) {
       return accountRepository.save(account);
   }


   public Account getAccount(long accountId) {
       return accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Not Found"));
   }


   public List<Account> getAccount() {
       return accountRepository.findAll();
   }


   public Account updateAccount(long accountId, Account account) {
       Account existingAccount = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Not Found"));
       existingAccount.setBalance(account.getBalance());
       existingAccount.setAccountHolderId(account.getAccountHolderId());
       accountRepository.save(existingAccount);
       return existingAccount;
   }
   
   
   public Account updateAccountWithdraw(long accountId, double withdrawAmount, Account account) {
       Account existingAccount = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Not Found"));
       
       double currentBalance = existingAccount.getBalance();
       double newBalance = currentBalance;
       
       if(currentBalance > withdrawAmount) {
    	   newBalance = currentBalance - withdrawAmount;
       }
       
       existingAccount.setBalance(newBalance);
       accountRepository.save(existingAccount);
       return existingAccount;
   }
   
   
   public Account updateAccountDeposit(long accountId, double depositAmount, Account account) {
       Account existingAccount = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Not Found"));
       
       double currentBalance = existingAccount.getBalance();
       double newBalance = currentBalance + depositAmount;
       
       existingAccount.setBalance(newBalance);
       accountRepository.save(existingAccount);
       return existingAccount;
   }


   public Account deleteaccount(long accountId) {
       Account existingAccount = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Not Found"));
       accountRepository.deleteById(accountId);
       return existingAccount;
   }


   public List<Account> getAccountById(long accountHolderId) {
       return accountRepository.getAccountById(accountHolderId);
   }
}