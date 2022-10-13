package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    protected Faker faker = new Faker();
    protected By email = By.id("email");
    protected By password = By.id("password");
    protected By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public Faker getFaker() {
        return faker;
    }

    public void login() {
        getEmail().sendKeys("admin@admin.com");
        getPassword().sendKeys("12345");
        getLoginBtn().click();
    }

    public void fakeLogin() {
        String email = faker.internet().emailAddress();
        String pass = faker.internet().password();
        getEmail().click();
        getEmail().sendKeys(email);
        getPassword().click();
        getPassword().sendKeys(pass);
        getLoginBtn().click();
    }


    public void wrongPass(String pass) {
        getEmail().sendKeys("admin@admin.com");
        getPassword().sendKeys(pass);
        if (pass != "12345") {
            getLoginBtn().click();
        }
    }


    public String getAttribute() {
        return getEmail().getAttribute("type");
    }


}
