package com.udemy.springbootseleniumqa.scope;

import com.udemy.springbootseleniumqa.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class JuniorSeniorTest extends SpringBaseTestNGTest {

    @Autowired
    private JuniorEngineer junior;

    @Autowired
    private SeniorEngineer senior;

    @Test
    public void scopeTest() {
        junior.setAmount(100);
        System.out.println("Junior :: " + junior.getSalary().getAmount());
        senior.setAmount(200);
        System.out.println("Senior :: " + senior.getSalary().getAmount());
        System.out.println("Junior :: " + junior.getSalary().getAmount());
    }

}
