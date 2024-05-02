package com.bankapp.bankapp.service;


import com.bankapp.bankapp.model.Account;
import com.bankapp.bankapp.model.Transaction;
import com.bankapp.bankapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TransactionService {


   @Autowired
   private TransactionRepository transactionRepository;


   public Transaction saveTransaction(Transaction transaction) {
       return transactionRepository.save(transaction);
   }


   public Transaction getTransaction(long transactionId) {
       return transactionRepository.findById(transactionId).orElseThrow(() -> new RuntimeException("Not Found"));
   }


   public List<Transaction> getTransaction() {
       return transactionRepository.findAll();
   }


   public Transaction deletetransaction(long transactionId) {
	   Transaction existingTransaction = transactionRepository.findById(transactionId).orElseThrow(() -> new RuntimeException("Not Found"));
	   transactionRepository.deleteById(transactionId);
       return existingTransaction;
   }
   
   public List<Transaction> getTransactionById(long accountHolderId) {
       return transactionRepository.getTransactionById(accountHolderId);
   }
}