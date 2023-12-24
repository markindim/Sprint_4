package ru.praktikum.services.scooter.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestInvalidStatusOrder {
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
    public void InvalidStatusOrder() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HomePage objHomePage = new HomePage(driver);
        driver.findElement(objHomePage.buttonStatusOrder).click();
        driver.findElement(objHomePage.inputNumberStatus).sendKeys("123456");
        driver.findElement(objHomePage.buttonGo).click();
        driver.findElement(By.xpath("//img[@alt=\"Not found\"]")).isDisplayed();
    }
}