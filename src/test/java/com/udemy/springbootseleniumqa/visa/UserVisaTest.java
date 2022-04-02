package com.udemy.springbootseleniumqa.visa;

import com.udemy.springbootseleniumqa.SpringBaseTestNGTest;
import com.udemy.springbootseleniumqa.entity.User;
import com.udemy.springbootseleniumqa.page.visa.VisaRegistrationPage;
import com.udemy.springbootseleniumqa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class UserVisaTest extends SpringBaseTestNGTest {

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Autowired
    private UserRepository repository;

    @Test(dataProvider = "getData")
    public void visaTest(User u) {
            registrationPage.goTo();
            registrationPage.setNames(u.getFirstName(), u.getLastName());
            registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            registrationPage.setBirthDate(u.getDob().toLocalDate());
            registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            registrationPage.setComments(u.getComments());
            registrationPage.submit();
            log.info("Request confirmation # INFO : " + registrationPage.getConfirmationNumber());
            log.warn("Request confirmation # WARN : " + registrationPage.getConfirmationNumber());
//            System.out.println(registrationPage.getConfirmationNumber());

    }

    @DataProvider
    public Object[] getData(ITestContext context) {
        return repository.findByDobBetween(
                Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo")))
                .stream()
                .limit(3)
                .toArray();
    }

//    @Test
//    public void visaTest() {
//        repository.findById(85).ifPresent(u -> System.out.println(u.getFirstName()));
//    }

//    @Test
//    public void visaTest() {
//        System.out.println(
//                repository.findAll().size()
//        );
//    }

}
