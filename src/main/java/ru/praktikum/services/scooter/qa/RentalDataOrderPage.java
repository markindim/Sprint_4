package ru.praktikum.services.scooter.qa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentalDataOrderPage {
    WebDriver driver;

    private final By datepicker = By.xpath(".//div[@class='react-datepicker__input-container']/input[@placeholder='* Когда привезти самокат']"); // локатор поля "Когда привезти самокат"
    private final String dateLabel = ".//div[@aria-label='%s']"; // локатор даты на календаре
    private final By dropdownDate = By.xpath(".//span[@class='Dropdown-arrow']"); // локатор выпадающего списка "Срок аренды"
    private final String selectDate = ".//div[@role='option' and text()='%s']"; // локатор выпадающего списка
    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"); // локатор кнопки "Заказать"
    private final By buttonConfirmOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"); // локатор кнопки "Да" модального окна подтверждения
    private final By buttonCheckOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']"); // локатор кнопки "Посмотреть статус"

    public RentalDataOrderPage (WebDriver driver) {
        this.driver = driver;
    }
    // метод ввода данных в форму "Про аренду"
    public void dataInputRental(String dateInput, String dateCalendar, String period, String color) {
        driver.findElement(datepicker).sendKeys(dateInput);
        driver.findElement(By.xpath(String.format(dateLabel, dateCalendar))).click();
        driver.findElement(dropdownDate).click();
        driver.findElement(By.xpath(String.format(selectDate, period))).click();
        driver.findElement((By.id(String.format("%s", color)))).click();
        driver.findElement(buttonOrder).click();
        driver.findElement(buttonConfirmOrder).click();
        driver.findElement(buttonCheckOrder).isDisplayed();
    }
}