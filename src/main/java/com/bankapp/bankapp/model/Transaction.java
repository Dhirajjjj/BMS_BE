package com.bankapp.bankapp.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "transactions")
@Data
public class Transaction {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long transactionId;


   @Column(name = "account_id", nullable = false)
   private long accountId;
   
   @Column(name = "type", nullable = false)
   private String type = "credit";

   @Column(name = "amount", nullable = false)
   private double amount = 0.00;

   @Column(name = "transaction_date")
   private Date transactionDate;
   
   public Transaction() { 
   }
   
   public Transaction(long transactionId, long accountId, String type, double amount, Date transactionDate) {
     this.transactionId = transactionId;
     this.accountId = accountId;
     this.type = type;
     this.amount = amount;
     this.transactionDate = transactionDate;
   }

   public Long getTransactionId() {
     return transactionId;
   }

   public void setTransactionId(long transactionId) {
     this.transactionId = transactionId;
   }

   public long getAccountId() {
     return accountId;
   }

   public void setAccountId(long accountId) {
     this.accountId = accountId;
   }
   
   public String getType() {
     return type;
   }

   public void setType(String transactionType) {
     this.type = transactionType;
   }

   public double getAmount() {
     return amount;
   }

   public void setAmount(double amount) {
     this.amount = amount;
   }

   public Date getTransactionDate() {
     return transactionDate;
   }

   public void setTransactionDate(Date transactionDate) {
     this.transactionDate = transactionDate;
   }
}
