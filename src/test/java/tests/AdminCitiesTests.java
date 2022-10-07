package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BaseTestPage{


    Faker faker = new Faker();
    //private String city = faker.address().city();



    @Test(priority = 1)
    public void citiesPage() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        adminCitiesPage.newItem(adminCitiesPage.getCity());
        Thread.sleep(2000);
        WebElement msgBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(msgBox.getText().contains("Saved successfully"));
        System.out.println(adminCitiesPage.getCity());
    }



    @Test(priority = 3)
    public void editCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.getEdit().click();
        adminCitiesPage.editCity();
        Thread.sleep(2000);
        WebElement msgBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(msgBox.getText().contains("Saved successfully"));
        System.out.println(adminCitiesPage.getEditedCity());
    }


    //Test #4: Search city
    //Podaci: editovani grad iz testa #3
    //assert:
    //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

    @Test(priority = 4)
    public void searchCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.search();
        Thread.sleep(7000);
        String expected = driver.findElement(By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td")).getText();
        Assert.assertTrue(adminCitiesPage.getSearch().getText().contains(expected));




    }

}
