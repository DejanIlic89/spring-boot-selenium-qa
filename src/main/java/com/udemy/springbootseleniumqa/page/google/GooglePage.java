package com.udemy.springbootseleniumqa.page.google;

import com.udemy.springbootseleniumqa.kelvin.annotation.Page;
import com.udemy.springbootseleniumqa.page.Base;
import io.qameta.allure.Allure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${app.url}")
    private String url;

    public void goTo() {
        Allure.addAttachment("url", url);
        driver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    @Override
    public boolean isAt() {
        return searchComponent.isAt();
    }

    public void close() {
        driver.quit();
    }

}
