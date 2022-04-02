package com.udemy.springbootseleniumqa.flights;

import com.udemy.springbootseleniumqa.SpringBaseTestNGTest;
import com.udemy.springbootseleniumqa.kelvin.annotation.LazyAutowired;
import com.udemy.springbootseleniumqa.page.flights.FlightPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class FlightTest extends SpringBaseTestNGTest {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @LazyAutowired
    private WebDriver driver;

    @Test
    public void flightTest() {
        flightPage.goTo(appDetails.getUrl());
        Assert.assertTrue(flightPage.isAt());
        Assert.assertEquals(flightPage.getLabels(), appDetails.getLabels());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
