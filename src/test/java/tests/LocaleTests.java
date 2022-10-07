package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocaleTests extends BaseTestPage{


    @Test(priority = 1)
    public void setES() throws InterruptedException {
        homePage.getLanguage().click();
        Thread.sleep(2000);
        WebElement espana = driver.findElement(By.xpath("//*[@id=\"list-item-75\"]/div"));
        espana.click();
        String expected = "Página de aterrizaje";
        WebElement actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertTrue(actual.getText().contains(expected));
    }

    @Test(priority = 2)
    public void setEN(){
        homePage.getLanguage().click();
        WebElement england = driver.findElement(By.xpath("//*[@id=\"list-item-73\"]/div"));
        england.click();
        String expected = "Landing";
        WebElement actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertTrue(actual.getText().contains(expected));
    }


    @Test(priority = 3)
    public void setFR(){
        homePage.getLanguage().click();
        WebElement france = driver.findElement(By.xpath("//*[@id=\"list-item-77\"]/div"));
        france.click();
        String expected = "Page d'atterrissage";
        WebElement actual = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));
        Assert.assertTrue(actual.getText().contains(expected));
    }

}
