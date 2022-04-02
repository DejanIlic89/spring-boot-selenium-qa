package com.udemy.springbootseleniumqa.page.window;

import com.udemy.springbootseleniumqa.kelvin.annotation.Page;
import com.udemy.springbootseleniumqa.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Page
public class MainPage extends Base {

    @FindBy(tagName = "a")
    private List<WebElement> links;

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    public void launchAllWindows() {
        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            wait.until(ExpectedConditions.numberOfWindowsToBe(i+2));
        }
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> !links.isEmpty());
    }

}
