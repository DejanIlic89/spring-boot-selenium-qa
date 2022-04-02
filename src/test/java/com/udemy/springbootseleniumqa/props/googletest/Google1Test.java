package com.udemy.springbootseleniumqa.props.googletest;

import com.udemy.springbootseleniumqa.SpringBaseTestNGTest;
import com.udemy.springbootseleniumqa.kelvin.annotation.LazyAutowired;
import com.udemy.springbootseleniumqa.kelvin.service.ScreenshotService;
import com.udemy.springbootseleniumqa.page.google.GooglePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google1Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private WebDriver driver;

    @AfterMethod
    private void tearDown() {
        driver.quit();
    }

    @Test
    private void googleTest() throws IOException {
        googlePage.goTo();
        Assert.assertTrue(googlePage.isAt());
        googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(googlePage.getSearchResult().isAt());
        Assert.assertTrue(googlePage.getSearchResult().getCount() > 2);
        screenshotService.takeScreenShot();
    }

}
