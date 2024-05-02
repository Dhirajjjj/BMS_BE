package com.bankapp.bankapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp.bankapp.model.Customer;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
   @Query(value = "SELECT * FROM customers WHERE name = ?1", nativeQuery = true)
   List<Customer> getCustomerByName(String customerName);
}

