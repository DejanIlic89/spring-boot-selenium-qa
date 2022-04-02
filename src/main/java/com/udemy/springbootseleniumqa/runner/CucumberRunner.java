package com.udemy.springbootseleniumqa.runner;

import io.cucumber.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.udemy.springbootseleniumqa.bdd",
        tags = "@google",
        plugin = {
                "pretty",
                "html:target/cucumber/cucumber-report.html",
                "json:target/cucumber/RunnerResults.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class CucumberRunner {

        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun = true)
        public void setUpClass() {
                testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @Test(dataProvider = "features")
        public void feature(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
                testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
        }

        @DataProvider(parallel = true)
        public Object[][] features() {
                return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() {
                testNGCucumberRunner.finish();
        }
}

