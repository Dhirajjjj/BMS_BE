package com.bankapp.bankapp.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "accounts")
@Data
public class Account {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long accountId;

   @Column(name = "balance")
   private double balance = 0.00;
   
   @Column(name = "account_holder_id")
   private long accountHolderId;

   @Column(name = "created_at")
   @Temporal(TemporalType.TIMESTAMP)
   private Date createdAt;
   
   public Account() { 
   }
   
   public Account(long accountId, double balance, long accountHolderId, Date createdAt) {
     this.accountId = accountId;
     this.balance = balance;
     this.accountHolderId = accountHolderId;
     this.createdAt = createdAt;
   }

   public Long getAccountId() {
     return accountId;
   }

   public void setAccountId(Long accountId) {
     this.accountId = accountId;
   }

   public double getBalance() {
     return balance;
   }

   public void setBalance(double balance) {
     this.balance = balance;
   }

   public long getAccountHolderId() {
     return accountHolderId;
   }

   public void setAccountHolderId(long accountHolderId) {
     this.accountHolderId = accountHolderId;
   }

   public Date getCreatedAt() {
     return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
     this.createdAt = createdAt;
   }
}

