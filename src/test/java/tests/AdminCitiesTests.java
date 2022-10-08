package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BaseTestPage{

    Faker faker = new Faker();


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
        adminCitiesPage.newItem();
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

    //Test #5: Delete city
    //Podaci: editovani grad iz testa #3
    //assert:
    //U polje za pretragu uneti staro ime grada
    //Sacekati da broj redova u tabeli bude 1
    //Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
    //Kliknuti na dugme Delete iz prvog reda
    //Sacekati da se dijalog za brisanje pojavi
    //Kliknuti na dugme Delete iz dijaloga
    //Sacekati da popu za prikaz poruke bude vidljiv
    //Verifikovati da poruka sadrzi tekst Deleted successfully

    @Test(priority = 5)
    public void deleteCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        Thread.sleep(2000);
        adminCitiesPage.cities();
        adminCitiesPage.getSearch().sendKeys(adminCitiesPage.getCity());
        String expected = adminCitiesPage.getCity();
        WebElement actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        Assert.assertTrue(actual.getText().contains(expected));
        WebElement deleteIcon = driver.findElement(By.xpath("//*[@id=\"delete\"]/span"));
        deleteIcon.click();
        WebElement delete = driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span"));
        delete.click();
        WebElement messageBox = driver.findElement (By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        // //*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]
        Assert.assertTrue(messageBox.getText().contains("Delete successfully"));

    }

}
// //*[@id="app"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div - closeMsg
