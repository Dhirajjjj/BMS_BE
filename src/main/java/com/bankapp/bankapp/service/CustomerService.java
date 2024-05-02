package com.bankapp.bankapp.service;


import com.bankapp.bankapp.model.Customer;
import com.bankapp.bankapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CustomerService {


   @Autowired
   private CustomerRepository customerRepository;


   public Customer saveCustomer(Customer customer) {
       return customerRepository.save(customer);
   }


   public Customer getCustomer(long customerId) {
       return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Not Found"));
   }


   public List<Customer> getCustomer() {
       return customerRepository.findAll();
   }


   public Customer updateCustomer(long customerId, Customer customer) {
       Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Not Found"));
       existingCustomer.setName(customer.getName());
       existingCustomer.setEmail(customer.getEmail());
       existingCustomer.setAddress(customer.getAddress());
       existingCustomer.setPhoneNumber(customer.getPhoneNumber());
       existingCustomer.setDateOfBirth(customer.getDateOfBirth());
       customerRepository.save(existingCustomer);
       return existingCustomer;
   }


   public Customer deletecustomer(long customerId) {
       Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Not Found"));
       customerRepository.deleteById(customerId);
       return existingCustomer;
   }


   public List<Customer> getCustomerByName(String customerName) {
       return customerRepository.getCustomerByName(customerName);
   }
}