package com.udemy.springbootseleniumqa.kelvin.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class WindowSwitchService {

    @Autowired
    private ApplicationContext ctx;

    public void switchByTitle(final String title) {
        WebDriver driver = ctx.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .map(handle ->
                        driver.switchTo().window(handle).getTitle()
//                        {
//                            WebDriver webDriver = driver.switchTo().window(handle);
//                            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//                            return webDriver.getTitle();
//                        }
                        )
                .filter(t -> t.startsWith(title))
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("No such window");
                });
    }

    public void switchByIndex(final int index) {
        WebDriver driver = ctx.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }

}
