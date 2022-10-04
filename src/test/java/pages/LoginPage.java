package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


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



    public void login(String email, String password){
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginBtn().click();
    }

    public String getAttribute(){
        return  getEmail().getAttribute("type");
    }


}
