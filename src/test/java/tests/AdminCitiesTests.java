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


    @Test()
    public void citiesPage() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        Assert.assertTrue(logoutBtn.isDisplayed());
    }


    @Test()
    public void createNewCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.newItem();
        WebElement msgBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(msgBox.getText().contains("Saved successfully"));
        System.out.println(adminCitiesPage.getCity());
    }



    @Test(dependsOnMethods = {"createNewCity"})
    public void editCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.getEdit().click();
        adminCitiesPage.editCity();
        WebElement msgBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(msgBox.getText().contains("Saved successfully"));
        System.out.println(adminCitiesPage.getEditedCity());
    }


    @Test(dependsOnMethods = {"createNewCity", "editCity"})
    public void searchCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.search();
        String expected = driver.findElement(By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td")).getText();
        Assert.assertTrue(adminCitiesPage.getSearch().getText().contains(expected));
    }


    @Test(priority = 1, dependsOnMethods = {"createNewCity", "editCity"})
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
//        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully\nCLOSE"));
//        boolean deleteMsgBox = driver.findElement(By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).getText().contains("Deleted successfully");
//        Assert.assertTrue(deleteMsgBox);
//        String expct = "Delete successfully" + "\nCLOSE";
//        WebElement messageBox = driver.findElement (By.xpath("//*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
//        // //*[@id='app']/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]
//        Assert.assertTrue(messageBox.getText().contains(expct));

    }

}
