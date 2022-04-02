package com.udemy.springbootseleniumqa.kelvin.aop;

import com.udemy.springbootseleniumqa.kelvin.annotation.Window;
import com.udemy.springbootseleniumqa.kelvin.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    /**
     * This means any class which has annotation @Window within com.udemy.springbootseleniumqa path
     * execute this method before any other method inside such class!
     * @param window
     */
    @Before("@target(window) && within(com.udemy.springbootseleniumqa..*)")
    public void before(Window window) {
        switchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.udemy.springbootseleniumqa..*)")
    public void after(Window window) {
        switchService.switchByIndex(0);
    }

}
