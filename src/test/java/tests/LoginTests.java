package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTestPage{

    @Test(priority = 1)
    public void visitTheLoginPage() throws InterruptedException {
        homePage.getLogin();
        Thread.sleep(2000);
        String currentUrl = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertTrue(currentUrl.contains("/login"));

    }

    @Test(priority = 2)
    public void checksInputTypes() throws InterruptedException {
        homePage.getLogin();
        Thread.sleep(1000);
        String expected = "email";
        String actual = loginPage.getAttribute();
        Assert.assertTrue(actual.equals(expected));


    }

}
