package com.udemy.springbootseleniumqa.bdd;

import com.udemy.springbootseleniumqa.kelvin.annotation.LazyAutowired;
import com.udemy.springbootseleniumqa.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.springframework.util.ObjectUtils;
import org.testng.Assert;

import java.time.LocalDate;

public class VisaSteps {

    @LazyAutowired
    private VisaRegistrationPage registrationPage;

    @Given("I am on VISA registration form")
    public void launchSite() {
        registrationPage.goTo();
        Allure.addAttachment("Payment", "Visa");
        Assert.assertTrue(registrationPage.isAt());
    }

    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to) {
        registrationPage.setCountryFromAndTo(from, to);
    }

    @When("I enter my dob as {string}")
    public void enterDob(String dob) {
        registrationPage.setBirthDate(LocalDate.parse(dob));
    }

    @When("I enter my name as {string} and {string}")
    public void enterNames(String fn, String ln) {
        registrationPage.setNames(fn, ln);
    }

    @When("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phone) {
        registrationPage.setContactDetails(email, phone);
    }

    @When("I enter the comment {string}")
    public void enterComment(String comment) {
        registrationPage.setComments(comment);

    }

    @When("I submit the form")
    public void submit() {
        registrationPage.submit();
    }

    @Then("I should see get the confirmation number")
    public void verifyConfirmationNumber() {
        boolean isEmpty = ObjectUtils.isEmpty(registrationPage.getConfirmationNumber().trim());
        Assert.assertFalse(isEmpty);
    }

}
