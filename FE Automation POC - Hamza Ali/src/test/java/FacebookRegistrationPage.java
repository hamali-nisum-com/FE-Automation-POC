import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class FacebookRegistrationPage {
    private  WebDriverWait wait;
    private WebDriver driver;

    // WebElements Locators
    private By registrationFormButton = By.xpath("//a[@data-testid='open-registration-form-button']");

    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By emailField = By.name("reg_email__");
    private By passwordField = By.name("reg_passwd__");
    private By genderRadioButton = By.xpath("//input[@value='2']");
    private By dayDropdown = By.name("birthday_day");
    private By monthDropdown = By.name("birthday_month");
    private By yearDropdown = By.name("birthday_year");
    private By submitButton = By.name("websubmit");

    public FacebookRegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        driver.findElement(registrationFormButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(genderRadioButton).click();

        // Select date
        new Select(driver.findElement(dayDropdown)).selectByVisibleText("11");

        // Select month
        new Select(driver.findElement(monthDropdown)).selectByVisibleText("May");

        // Select year
        new Select(driver.findElement(yearDropdown)).selectByVisibleText("1990");
    }

    public void submitRegistrationForm() {
        driver.findElement(submitButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}