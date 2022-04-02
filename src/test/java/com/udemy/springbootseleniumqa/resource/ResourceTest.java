package com.udemy.springbootseleniumqa.resource;

import com.udemy.springbootseleniumqa.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNGTest {

//    @Value("classpath:data/testdata.csv")
//    private Resource resource;

//    @Value("file:E:\\spring-boot-selenium-qa\\src\\test\\resources\\data\\testdata.csv")
//    private Resource resource;

//    @Value("https://www.google.com")
//    private Resource resource;

//    @Value("https://www.w3.org/TR/PNG/iso_8859-1.txt")
//    private Resource resource;

//    @Value("${data.path}/some.txt")
//    private Path path;

    @Value("${data.path}")
    private Path path;

    @Value("classpath:data/resourcedata.csv")
    private Resource resource;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test(dataProvider = "getData")
    public void resourceTest(String url, String saveAs) throws IOException {

//        Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);

//        System.out.println(new String(resource.getInputStream().readAllBytes()));

//        FileCopyUtils.copy(resource.getInputStream(), Files.newOutputStream(path));

        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(saveAs))
        );
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resource.getFile().toPath())
                .stream()
                .map(s -> s.split(","))
                .toArray(Object[][]::new);
    }

}
