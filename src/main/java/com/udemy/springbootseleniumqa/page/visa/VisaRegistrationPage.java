package com.udemy.springbootseleniumqa.page.visa;

import com.udemy.springbootseleniumqa.kelvin.annotation.Page;
import com.udemy.springbootseleniumqa.page.Base;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.Objects;

@Slf4j
@Page
public class VisaRegistrationPage extends Base {

    @FindBy(id = "first_4")
    private WebElement firstName;
    @FindBy(id = "last_4")
    private WebElement lastName;
    @FindBy(id = "input_46")
    private WebElement fromCountry;
    @FindBy(id = "input_47")
    private WebElement toCountry;
    @FindBy(id = "input_24_month")
    private WebElement month;
    @FindBy(id = "input_24_day")
    private WebElement day;
    @FindBy(id = "input_24_year")
    private WebElement year;
    @FindBy(id = "input_6")
    private WebElement email;
    @FindBy(id = "input_27_phone")
    private WebElement phone;
    @FindBy(id = "input_45")
    private WebElement comments;
    @FindBy(id = "submitBtn")
    private WebElement submit;
    @FindBy(id = "requestnumber")
    private WebElement requestNumber;

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");
    }

    public void setNames(String firstName, String lastName) {
        log.debug("Getting names : " + firstName);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
    }

    public void setCountryFromAndTo(String countryFrom, String countryTo) {

        new Select(fromCountry).selectByValue(countryFrom);
        new Select(toCountry).selectByValue(countryTo);
    }

    public void setBirthDate(LocalDate localDate) {
        new Select(year).selectByVisibleText(String.valueOf(localDate.getYear()));
        new Select(day).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
        new Select(month).selectByValue(localDate.getMonth().toString());
    }

    public void setContactDetails(String email, String phone) {
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
    }

    public void setComments(String comments) {
        this.comments.sendKeys(Objects.toString(comments, ""));
    }

    public void submit() {
        submit.click();
    }

    public String getConfirmationNumber() {
        wait.until(d -> requestNumber.isDisplayed());
        return requestNumber.getText();
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> firstName.isDisplayed());
    }

}
