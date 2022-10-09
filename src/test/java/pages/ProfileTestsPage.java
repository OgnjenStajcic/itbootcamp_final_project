package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileTestsPage extends BasePage{

    protected By myProfile = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span");
    protected By name = By.id("name");
    protected By phone = By.id("phone");
    protected By city = By.id("city");
    protected By xPhone = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button");
    protected By xCity = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button");
    protected By dropDown = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[2]/div");
    protected By country = By.id("country");
    protected By twitter = By.id("urlTwitter");
    protected By gitHub = By.id("urlGitHub");
    protected By save = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    protected By chosenCity = By.xpath("//*[@id=\"list-item-163-1\"]/div/div");

    protected By msgBox = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");
    Faker faker = new Faker();

    protected String randomName = faker.name().fullName();
    protected String randomPhone = faker.phoneNumber().cellPhone();
    protected String randomCountry = faker.address().country();
    protected String randomTwitter = faker.internet().url();
    protected String randomGit = faker.internet().url();





    public ProfileTestsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public Faker getFaker() {
        return faker;
    }

    public String getRandomName() {
        return randomName;
    }

    public String getRandomPhone() {
        return randomPhone;
    }

    public String getRandomCountry() {
        return randomCountry;
    }

    public String getRandomTwitter() {
        return randomTwitter;
    }

    public String getRandomGit() {
        return randomGit;
    }

    public WebElement getMsgBox() {
        return getDriver().findElement(msgBox);
    }

    public WebElement getMyProfile() {
        return getDriver().findElement(myProfile);
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getCity() {
        return getDriver().findElement(city);
    }

    public WebElement getxPhone() {
        return getDriver().findElement(xPhone);
    }

    public WebElement getxCity() {
        return getDriver().findElement(xCity);
    }

    public WebElement getDropDown() {
        return getDriver().findElement(dropDown);
    }

    public WebElement getCountry() {
        return getDriver().findElement(country);
    }

    public WebElement getTwitter() {
        return getDriver().findElement(twitter);
    }

    public WebElement getGitHub() {
        return getDriver().findElement(gitHub);
    }

    public WebElement getSave() {
        return getDriver().findElement(save);
    }


        public WebElement getChosenCity() {
        return getDriver().findElement(chosenCity);
    }

    public WebElement getPhone() {
        return getDriver().findElement(phone);
    }


    // //*[@id="app"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button - x od phone
    // //*[@id="app"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button


    public void nameChange(String name){
        getName().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getName().sendKeys(name);
    }

    public void phoneChange(String phone){
        getPhone().click();
        getxPhone().click();
        getPhone().sendKeys(phone);
    }

    public void cityChange() throws InterruptedException {
        getMyProfile().click();
        getCity().click();
        Thread.sleep(3000);
        getChosenCity().click();
    }

    public void countryChange(String country){
        getCountry().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getCountry().sendKeys(country);
    }

    public void twitterChange(String twitter){
        getTwitter().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getTwitter().sendKeys(twitter);
    }

    public void gitHubChange(String git){
        getGitHub().click();
        getName().sendKeys(Keys.CONTROL + "A", Keys.DELETE);
        getGitHub().sendKeys(git);
    }


}
