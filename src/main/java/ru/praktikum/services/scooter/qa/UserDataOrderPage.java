package ru.praktikum.services.scooter.qa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDataOrderPage {
    WebDriver driver;
    HomePage HomePage = new HomePage(driver);

    private final By nameField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']"); // локатор поля "Имя"
    private final By surnameField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']"); // локатор поля "Фамилия"
    private final By addressField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']"); // локатор поля "Адресс: куда привехти заказ"
    private final By telephoneField = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']"); // локатор поля "Телефон: на него позвонит курьер"
    private final By stationMetroFieldValue = By.className("select-search__input"); // локатор поля выбора Метро
    private final By stationMetroClick = By.className("select-search__select"); // локатор выбора метро из выпадающего списка
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']"); // локатор кнопки "Далее"

    public UserDataOrderPage (WebDriver driver) {
        this.driver = driver;
    }

    // метод ввода данных в форму "Для кого самокат"
    public void dataInput (String name, String surname, String address, String metroStation, String telephone){
        driver.findElement(HomePage.buttonOrderHeader).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(stationMetroFieldValue).sendKeys(metroStation);
        driver.findElement(stationMetroClick).click();
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(buttonNext).click();
    }
}