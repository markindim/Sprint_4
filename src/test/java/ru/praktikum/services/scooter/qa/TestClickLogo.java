package ru.praktikum.services.scooter.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TestClickLogo {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyClickLogoYandex() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(driver);
        homePage.clickLogoYandex();
        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String expectedUrl = "https://dzen.ru";
        String actualUrl = driver.getCurrentUrl();
        actualUrl = actualUrl.substring(0, 15);
        assertEquals("URL страницы не совпадает", expectedUrl, actualUrl);
    }

    @Test
    public void verifyClicklogoScooter() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonOrderHeader();
        homePage.clickLogoScooter();
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL не совпадает", expectedUrl, actualUrl);
    }
}