package com.bankapp.bankapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp.bankapp.model.Account;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {
   @Query(value = "SELECT * FROM accounts WHERE account_holder_id = ?1", nativeQuery = true)
   List<Account> getAccountById(long accountHolderId);
}

