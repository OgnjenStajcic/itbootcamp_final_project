package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminCitiesPage extends BasePage{

    protected By admin = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span");
    protected By cities = By.xpath("//*[@id=\"app\"]/div[3]/div[1]/a[1]");
    protected By newItem = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    protected By name = By.id("name");
    protected Faker faker = new Faker();
    protected By save = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span");
    protected By logout = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span");
    private String city;


    public AdminCitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLogout() {
        return getDriver().findElement(logout);
    }

    public WebElement getAdmin() {
        return getDriver().findElement(admin);
    }

    public WebElement getCities() {
        return getDriver().findElement(cities);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getSave() {
        return getDriver().findElement(save);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Faker getFaker() {
        return faker;
    }

    public WebElement getNewItem() {
        return getDriver().findElement(newItem);
    }

    public void adminClick(){
        getAdmin().click();
    }

    public void cities(){
        getCities().click();
    }

    public void newItem(){
        getNewItem().click();
        //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        city = faker.address().city();
        getName().sendKeys(city);
        getSave().click();

    }

    public void logout(){
        getLogout().click();
    }


}
