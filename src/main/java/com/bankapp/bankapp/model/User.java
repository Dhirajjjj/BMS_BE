package com.bankapp.bankapp.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "user")
@Data
public class User {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;


   @Column(name = "name", nullable = false)
   private String name;


   @Column(name = "email", nullable = false, unique = true)
   private String email;
   
   private String password;


   @Temporal(TemporalType.DATE)
   private Date dateOfBirth;
	
   @Column(name = "address")
   private String address;
	
   @Column(name = "phone_number")
   private String phoneNumber;

   @Column(name = "created_at")
   private Date createdAt;
   
   public User() { 
   }
   
   public User(String name, String email, String password, Date dateOfBirth, String address, String phoneNumber, Date createdAt) {
     this.name = name;
     this.email = email;
     this.password = password;
     this.dateOfBirth = dateOfBirth;
     this.address = address;
     this.phoneNumber = phoneNumber;
     this.createdAt = createdAt;
   }

   public Long getId() {
     return id;
   }

   public void setId(Long id) {
     this.id = id;
   }

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }

   public String getEmail() {
     return email;
   }

   public void setEmail(String email) {
     this.email = email;
   }

   public Date getDateOfBirth() {
     return dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth) {
     this.dateOfBirth = dateOfBirth;
   }

   public String getAddress() {
     return address;
   }

   public void setAddress(String address) {
     this.address = address;
   }

   public String getPhoneNumber() {
     return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
   }

   public Date getCreatedAt() {
     return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
     this.createdAt = createdAt;
   }

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
	    this.password = password;
	}
}
