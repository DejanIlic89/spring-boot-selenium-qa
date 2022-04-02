package com.udemy.springbootseleniumqa.kelvin.aop;

import com.udemy.springbootseleniumqa.kelvin.annotation.TakeScreenshot;
import com.udemy.springbootseleniumqa.kelvin.service.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException {
        screenshotService.takeScreenShot();
//        return screenshotService.getScreenshot();
//        screenshotService.takeScreenshotAllure();
    }

}
