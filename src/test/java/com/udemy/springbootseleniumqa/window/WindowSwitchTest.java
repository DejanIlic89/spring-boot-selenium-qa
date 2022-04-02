package com.udemy.springbootseleniumqa.window;

import com.udemy.springbootseleniumqa.SpringBaseTestNGTest;
import com.udemy.springbootseleniumqa.kelvin.service.WindowSwitchService;
import com.udemy.springbootseleniumqa.page.window.MainPage;
import com.udemy.springbootseleniumqa.page.window.PageA;
import com.udemy.springbootseleniumqa.page.window.PageB;
import com.udemy.springbootseleniumqa.page.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=firefox")
public class WindowSwitchTest extends SpringBaseTestNGTest {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;

    @Autowired
    private PageB pageB;

    @Autowired
    private PageC pageC;

    @Autowired
    private WindowSwitchService switchService;

    /**
     * Be careful with @Before TestNG annotations and Spring Boot
     * All above Autowired objects are not available within @BeforeSuite, @BeforeTest, @BeforeGroups blocks
     * But they are available within @BeforeClass, @BeforeMethod and @Test blocks
     */

    @BeforeClass
    public void setup() {
        mainPage.goTo();
        mainPage.isAt();
        mainPage.launchAllWindows();
    }

//    @Test
//    public void switchTest() {
//        switchService.switchByTitle("Page A");
//        pageA.addToArea("Hi page A");
//        switchService.switchByIndex(2);
//        pageB.addToArea("Hello page B");
//    }

    @Test(dataProvider = "getData")
    public void switchTest(int index) {
        pageA.addToArea(index + "\n");
        pageB.addToArea((index * 2) + "\n");
        pageC.addToArea((index * 3) + "\n");
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                3,
                4,
                1,
                5,
                6,
                2
        };
    }

}
