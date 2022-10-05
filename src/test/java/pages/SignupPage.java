package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{

    protected By name = By.id("name");
    protected By email = By.id("email");
    protected By password = By.id("password");
    protected By confirm = By.id("confirmPassword");
    protected By signMeUpBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");

    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirm() {
        return getDriver().findElement(confirm);
    }

    public WebElement getSignMeUpBtn() {
        return getDriver().findElement(signMeUpBtn);
    }

    public void signUp(String name, String email, String password, String confirm){
        getName().sendKeys(name);
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getConfirm().sendKeys(confirm);
        getSignMeUpBtn().click();
    }



}
