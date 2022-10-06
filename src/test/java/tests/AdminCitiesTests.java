package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BaseTestPage{


    // Test #1: Visits the admin cities page and list cities
    //Podaci:
    //admin email: admin@admin.com
    //admin password: 12345
    //assert:
    //Verifikovati da se u url-u stranice javlja /admin/cities ruta
    //Verifikovati postojanje logut dugmeta


    @Test(priority = 1)
    public void citiesPage() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // Thread.sleep(3000);
        adminCitiesPage.cities();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        Assert.assertTrue(logoutBtn.isDisplayed());
    }


}
