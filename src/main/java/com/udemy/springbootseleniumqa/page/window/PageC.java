package com.udemy.springbootseleniumqa.page.window;

import com.udemy.springbootseleniumqa.kelvin.annotation.Window;
import com.udemy.springbootseleniumqa.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window(value = "Page C")
public class PageC extends Base {

    @FindBy(id = "area")
    private WebElement textArea;

    public void addToArea(final String msg) {
        textArea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> textArea.isDisplayed());
    }
}
