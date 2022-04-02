package com.udemy.springbootseleniumqa.page.google;

import com.udemy.springbootseleniumqa.kelvin.annotation.PageFragment;
import com.udemy.springbootseleniumqa.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends Base {

    @FindBy(name = "q")
    private WebElement searchBox;
    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    @Override
    public boolean isAt() {
        return wait.until(d -> searchBox.isDisplayed());
    }

    public void search(final String keyword) {
        searchBox.sendKeys(keyword);
        searchBox.sendKeys(Keys.TAB);
        searchBtns.stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
