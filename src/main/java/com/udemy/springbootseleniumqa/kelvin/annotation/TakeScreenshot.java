package com.udemy.springbootseleniumqa.kelvin.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TakeScreenshot {
}
