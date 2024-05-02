package com.bankapp.bankapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp.bankapp.model.Transaction;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
   @Query(value = "SELECT * FROM transactions WHERE account_id = ?1", nativeQuery = true)
   List<Transaction> getTransactionById(long accountId);
}

