package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage{

    protected By admin = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span");
    protected By cities = By.xpath("//*[@id=\"list-item-117\"]/div[2]");

    public AdminCitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAdmin() {
        return getDriver().findElement(admin);
    }

    public WebElement getCities() {
        return getDriver().findElement(cities);
    }

    public void adminClick(){
        getAdmin().click();
    }

    public void cities(){
        getCities().click();
    }

}
