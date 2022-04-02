package com.udemy.springbootseleniumqa.kelvin.service;

import com.github.javafaker.Faker;
import com.udemy.springbootseleniumqa.kelvin.annotation.LazyAutowired;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Slf4j
@Lazy
@Service
public class ScreenshotService {

    @LazyAutowired
    private ApplicationContext ctx;

    @LazyAutowired
    private Faker faker;

    @Value("${screenshot.path}")
    private Path path;

    // If you have time-consuming operations withing @PostConstruct bean creating part,
    // good practice is that bean to be marked with @Lazy annotation.
//    @PostConstruct
//    private void init() {
//        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Sleeping.....");
//        }
//    }

    public void takeScreenShot() throws IOException {
        File sourceFile = ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        path.toFile().mkdirs();
        File out = path.resolve("img_".concat(faker.random().hex(10)).concat(".png")).toFile();
        FileCopyUtils.copy(sourceFile, out);
    }

    public void takeScreenshotAllure() {
        Allure.getLifecycle().addAttachment("ImageFailure", "image/png", "png", getScreenshot());
    }

    public byte[] getScreenshot() {
        return ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

    public byte[] getScreenShot() {
        Screenshot screenShot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(ctx.getBean(WebDriver.class));
        BufferedImage originalImage = screenShot.getImage();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(originalImage, "png", outputStream);
            outputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return outputStream.toByteArray();
    }

}
