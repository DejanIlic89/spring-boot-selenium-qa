package com.udemy.springbootseleniumqa.page.google;

import com.udemy.springbootseleniumqa.kelvin.annotation.PageFragment;
import com.udemy.springbootseleniumqa.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends Base {

    @FindBy(css = "div.g")
    private List<WebElement> results;

    public int getCount() {
        return results.size();
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> !results.isEmpty());
    }
}
