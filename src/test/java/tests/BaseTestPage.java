package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

import java.time.Duration;

public abstract class BaseTestPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SignupPage signupPage;
    protected AdminCitiesPage adminCitiesPage;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Destop PC\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        homePage = new HomePage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        adminCitiesPage = new AdminCitiesPage(driver, wait);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.manage().window().maximize();
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }





}
