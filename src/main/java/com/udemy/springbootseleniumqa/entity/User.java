package com.udemy.springbootseleniumqa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Getter
@Setter
public class User {

    @Id
    private Integer id;
    private String fromCountry;
    private String toCountry;
    private Date dob;
    private String firstName;
    private String lastName;
    @Column(name = "customer_email")
    private String email;
    private String phone;
    private String comments;

}
