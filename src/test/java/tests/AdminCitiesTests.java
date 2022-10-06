package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BaseTestPage{



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


    @Test(priority = 2)
    public void createNewCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.newItem();
        Thread.sleep(2000);
        WebElement msgBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(msgBox.getText().contains("Saved successfully"));
    }


    //Test #3: Edit city
    //Podaci: edituje se grad koji je u testu 2 kreiran na isto ime + - edited
    //(primer: Beograd – Beograd edited)
    //assert:
    //Verifikovati da poruka sadrzi tekst Saved successfully

    @Test(priority = 3)
    public void editCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.newItem();
        WebElement edit = driver.findElement(By.xpath("//*[@id=\"edit\"]/span/i"));
        edit.click();
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys(" - edited");
        adminCitiesPage.getSave().click();
        Thread.sleep(2000);
        WebElement msgBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(msgBox.getText().contains("Saved successfully"));

    }

}
