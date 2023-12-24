package ru.praktikum.services.scooter.qa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    final By buttonOrderHeader = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']"); // локатор кнопки "Заказать" в хедере
    final By buttonOrderRoadMap = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button"); // локатор кнопки "Заказать" на странице
    final By buttonStatusOrder = By.xpath(".//button[@class='Header_Link__1TAG7' and text()='Статус заказа']"); // локатор кнопка "Статус заказа"
    private final By cookieButton = By.id("rcc-confirm-button"); // кнопка "да все привыкли" cookie
    private final String dropdownMenu = "accordion__heading-%d"; // id выпадающего списка
    private final String dropdownText = "accordion__panel-%d";   // id поля текста из выпадающего списка
    private final By logoYandex = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']/img[@alt='Yandex']"); // локатор логотипа "Яндекс"
    private final By logoScooter = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']/img[@alt='Scooter']"); // локатор логотипа "Самокат"
    final By inputNumberStatus = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='Введите номер заказа']");
    final By buttonGo = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']"); // локатор кнопки "Go"

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // метод клика по выпадающему списку
    public void clickDropdownMenu(int index) {
        driver.findElement(By.id(String.format(dropdownMenu, index))).click();
    }

    // метод получения текста выпадающего списка
    public String getDropdownText(int index) {
        return driver.findElement(By.id(String.format(dropdownText, index))).getText();
    }

    // метода клика по кнопке cookie
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // метод клика по логотипу "Яндекс"
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    // метод клика по логотипу "Самокат"
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }

    // метод клика по кнопке "Заказать" в хедере
    public void clickButtonOrderHeader() {
        driver.findElement(buttonOrderHeader).click();
    }

    // метод клика по кнопке "Заказать" на странице
    public void clickButtonOrderRoadMap() {
        driver.findElement(buttonOrderRoadMap).click();
    }
}