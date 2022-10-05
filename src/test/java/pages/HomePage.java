package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage  {

    protected By home = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[1]/span");
    protected By about = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[2]/span");
    protected By login = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    protected By signUp = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]/span");
    protected By switchTheme = By.id("input-26");
    protected By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");

    protected By language = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button/span");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHome() {
        return getDriver().findElement(home);
    }

    public WebElement getAbout() {
        return getDriver().findElement(about);
    }

    public WebElement getLogin() {
        return getDriver().findElement(login);
    }

    public WebElement getSignUp() {
        return getDriver().findElement(signUp);
    }

    public WebElement getSwitchTheme() {
        return getDriver().findElement(switchTheme);
    }

    public WebElement getLanguage() {
        return getDriver().findElement(language);
    }

    public WebElement getLogoutBtn() {
        return getDriver().findElement(logoutBtn);
    }

    public void login(){
        getLogin().click();
    }

    public void logout(){
        getLogoutBtn().click();
    }

}
