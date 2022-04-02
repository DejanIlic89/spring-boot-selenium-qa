package com.udemy.springbootseleniumqa.repository;

import com.udemy.springbootseleniumqa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFirstNameStartingWith(String startsWith);
    List<User> findByDobBetween(Date from, Date to);
}
