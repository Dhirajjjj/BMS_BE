package com.bankapp.bankapp.controller;

import com.bankapp.bankapp.model.Account;
import com.bankapp.bankapp.model.Transaction;
import com.bankapp.bankapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin
public class TransactionController {


   @Autowired
   private TransactionService transactionService;


  // insert a product into database
   @PostMapping("/transaction/create")
   public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
	 Transaction savedTransaction = transactionService.saveTransaction(transaction);
     return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
   }


  //get a single product by its id
   @GetMapping("/transaction")
   public ResponseEntity<Transaction> getTransaction(@RequestParam(name = "transactionId") long transactionId) {
	   Transaction transaction = transactionService.getTransaction(transactionId);
       return new ResponseEntity<>(transaction, HttpStatus.OK);
   }


   //get all the products in the table in our database
   @GetMapping("/transaction/all")
   public List<Transaction> getTransaction() {
       return transactionService.getTransaction();
   }


   // delete an existing product in the database
   @DeleteMapping("/transaction")
   public ResponseEntity<Transaction> deleteTransaction(@RequestParam(name ="transactionId") long transactionId) {
	   Transaction deletedTransaction = transactionService.deletetransaction(transactionId);
       return new ResponseEntity<>(deletedTransaction, HttpStatus.OK);
   }
   
   @GetMapping("/transaction-by-holder-id")
   public List<Transaction> getAccountById(@RequestParam(name ="accountId") long accountId) {
       return transactionService.getTransactionById(accountId);
   } 
}
