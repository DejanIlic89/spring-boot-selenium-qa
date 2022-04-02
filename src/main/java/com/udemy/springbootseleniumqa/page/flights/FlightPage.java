package com.udemy.springbootseleniumqa.page.flights;

import com.udemy.springbootseleniumqa.kelvin.annotation.Page;
import com.udemy.springbootseleniumqa.kelvin.annotation.TakeScreenshot;
import com.udemy.springbootseleniumqa.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends Base {

    @FindBy(css = "a.P4z3kc")
    private List<WebElement> elements;

    public void goTo(final String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @TakeScreenshot
    public List<String> getLabels() {
        return elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> !elements.isEmpty());
    }

}
