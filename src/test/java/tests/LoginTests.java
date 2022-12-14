package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTestPage{

    @Test(priority = 1)
    public void visitTheLoginPage() throws InterruptedException {
        homePage.login();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
    }

    @Test(priority = 2)
    public void checksInputTypes() throws InterruptedException {
        homePage.login();
        Thread.sleep(1000);
        String expected = "email";
        String actual = loginPage.getEmail().getAttribute("type");
        Assert.assertTrue(actual.equals(expected));
        String expctd = "password";
        String actl = loginPage.getPassword().getAttribute("type");
        Assert.assertTrue(actl.equals(expctd));
    }

    @Test(priority = 3)
    public void displaysErrors() throws InterruptedException {
        homePage.login();
        loginPage.fakeLogin();
        Thread.sleep(2000);
        WebElement closeBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div"));
        String expected = "User does not exists";
        Assert.assertTrue(closeBox.getText().contains(expected));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }


    @Test(priority = 4)
    public void wrongPassword() {
        homePage.login();
        loginPage.wrongPass("sfasad");
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        String expected = "Wrong password";
        Assert.assertTrue(closeBtn.getText().contains(expected));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("login"));
    }

    @Test(priority = 5)
    public void login(){
        homePage.login();
        loginPage.login();
        String url = "https://vue-demo.daniel-avellaneda.com/home";
        Assert.assertTrue(url.contains("/home"));
    }


    @Test(priority = 6)
    public void logout() throws InterruptedException {
        homePage.login();
        loginPage.login();
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());
        homePage.logout();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }


}
