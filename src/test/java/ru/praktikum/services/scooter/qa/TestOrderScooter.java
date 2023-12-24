package ru.praktikum.services.scooter.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestOrderScooter {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String dateInput;
    private final String dateCalendar;
    private final String period;
    private final String color;
    WebDriver driver;

    public TestOrderScooter(String name, String surname, String address, String metroStation, String telephone, String dateInput, String dateCalendar, String period, String color) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.dateInput = dateInput;
        this.dateCalendar = dateCalendar;
        this.period = period;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] dataTest() {
        return new Object[][]{
                {"Николай", "Смирнов", "г.Москва, ул. Краснодонская, д.28", "Братиславская", "+79775641234", "21.12.2023", "Choose четверг, 21-е декабря 2023 г.", "сутки", "black"},
                {"Петр", "Петров", "г.Москва, пр-к Вернадского, д.154", "Проспект Вернадского", "+79876543210", "03.02.2024", "Choose суббота, 3-е февраля 2024 г.", "четверо суток", "grey"}
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
    }

    @Test
    public void orderScooterClickButtonHeader() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonOrderHeader();
        UserDataOrderPage objUserPageOrderDate = new UserDataOrderPage(driver);
        objUserPageOrderDate.dataInput(name, surname, address, metroStation, telephone);
        RentalDataOrderPage objRentalDataOrderPage = new RentalDataOrderPage(driver);
        objRentalDataOrderPage.dataInputRental(dateInput, dateCalendar, period, color);
    }

    @Test
    public void orderScooterClickButtonRoadMap() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookieButton();
        WebElement element = driver.findElement(homePage.buttonOrderRoadMap);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        homePage.clickButtonOrderRoadMap();
        UserDataOrderPage objUserPageOrderDate = new UserDataOrderPage(driver);
        objUserPageOrderDate.dataInput(name, surname, address, metroStation, telephone);
        RentalDataOrderPage objRentalDataOrderPage = new RentalDataOrderPage(driver);
        objRentalDataOrderPage.dataInputRental(dateInput, dateCalendar, period, color);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}