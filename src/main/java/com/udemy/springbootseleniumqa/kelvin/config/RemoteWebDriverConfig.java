package com.udemy.springbootseleniumqa.kelvin.config;

import com.udemy.springbootseleniumqa.kelvin.annotation.LazyConfiguration;
import com.udemy.springbootseleniumqa.kelvin.annotation.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver() {
        FirefoxOptions capabilities = new FirefoxOptions();
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url, capabilities);
        Runtime.getRuntime().addShutdownHook(new Thread(remoteWebDriver::quit));
        return remoteWebDriver;
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver() {
        ChromeOptions capabilities = new ChromeOptions();
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(url, capabilities);
        Runtime.getRuntime().addShutdownHook(new Thread(remoteWebDriver::quit));
        return remoteWebDriver;
    }

}
