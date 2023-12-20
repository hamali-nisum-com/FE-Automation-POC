import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FacebookRegistrationTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        // Create instances of the page classes
        FacebookRegistrationPage registrationPage = new FacebookRegistrationPage(driver);

        // Fill and submit the registration form
        registrationPage.fillRegistrationForm("Hamza", "Ali", "03363177725", "abc12345@");
        registrationPage.submitRegistrationForm();

        // Assert the page title
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = registrationPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        // Quit the browser
        driver.quit();
    }
}
