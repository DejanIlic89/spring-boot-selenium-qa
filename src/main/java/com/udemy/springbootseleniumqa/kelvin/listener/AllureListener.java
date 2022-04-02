package com.udemy.springbootseleniumqa.kelvin.listener;

import com.udemy.springbootseleniumqa.kelvin.annotation.LazyAutowired;
import com.udemy.springbootseleniumqa.kelvin.annotation.TakeScreenshot;
import com.udemy.springbootseleniumqa.kelvin.service.ScreenshotService;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@Slf4j
public class AllureListener implements StepLifecycleListener {

    @LazyAutowired
    private ApplicationContext ctx;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private TakesScreenshot driver;

    @Override
    public void afterStepUpdate(StepResult result) {
        if (result.getStatus().equals(Status.FAILED) || result.getStatus().equals(Status.BROKEN)) {
//            byte[] screenShot = ctx.getBean(ScreenshotService.class).getScreenshot();
//            Allure.getLifecycle().addAttachment(result.getName(), "image/png", "png", screenShot);
        }
    }

}
