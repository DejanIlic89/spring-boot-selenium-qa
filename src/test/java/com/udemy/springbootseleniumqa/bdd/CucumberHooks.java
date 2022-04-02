package com.udemy.springbootseleniumqa.bdd;

import com.udemy.springbootseleniumqa.kelvin.annotation.LazyAutowired;
import com.udemy.springbootseleniumqa.kelvin.service.ScreenshotService;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

public class CucumberHooks {

    @LazyAutowired
    private ApplicationContext applicationContext;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
//            Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(screenshotService.getScreenshot()));
//            Allure.getLifecycle().addAttachment(scenario.getName(), "image/png", "png", screenshotService.getScreenShot());
            scenario.attach(screenshotService.getScreenshot(), "image/png", scenario.getName());
            scenario.attach(new Timestamp(new Date().getTime()).toString(), "text/plain","Timestamp");
        }
    }

//    @After
//    public void afterScenario(Scenario scenario) {
//        applicationContext.getBean(WebDriver.class).quit();
//    }

}
