package com.bankapp.bankapp.controller;

import com.bankapp.bankapp.model.Customer;
import com.bankapp.bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class CustomerController {


   @Autowired
   private CustomerService customerService;


  // insert a product into database
   @PostMapping("/customer")
   public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
     Customer savedCustomer = customerService.saveCustomer(customer);
     return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
   }


  //get a single product by its id
   @GetMapping("/customer")
   public ResponseEntity<Customer> getCustomer(@RequestParam(name = "customerId") long customerId) {
       Customer customer = customerService.getCustomer(customerId);
       return new ResponseEntity<>(customer, HttpStatus.OK);
   }


   //get all the products in the table in our database
   @GetMapping("/customer/all")
   public List<Customer> getCustomer() {
       return customerService.getCustomer();
   }


   //update an existing product in the database
   @PatchMapping("/customer")
   public ResponseEntity<Customer> updateCustomer(@RequestParam(name ="customerId") long customerId, @RequestBody Customer customer) {
       Customer updatedCustomer = customerService.updateCustomer(customerId, customer);
       return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
   }


   // delete an existing product in the database
   @DeleteMapping("/customer")
   public ResponseEntity<Customer> deleteCustomer(@RequestParam(name ="customerId") long customerId) {
       Customer deletedCustomer = customerService.deletecustomer(customerId);
       return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
   }


   // get product by name using a raw SQL statement
   @GetMapping("/customer-by-name")
   public List<Customer> getCustomerByName(@RequestParam(name ="customerName") String customerName) {
       return customerService.getCustomerByName(customerName);
   }  
}
