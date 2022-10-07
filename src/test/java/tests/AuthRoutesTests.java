package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTestPage{

    @Test(priority = 1)
    public void forbidsHomeUrl(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expected = "/login";
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }

    @Test(priority = 2)
    public void forbidsProfileUrl(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expected = "/login";
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }

    @Test(priority = 3)
    public void forbidsAdminCities() throws InterruptedException {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expected = "/login";
        String actual = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertTrue(actual.contains(expected));
    }

    @Test(priority = 4)
    public void forbidsAdminUsers(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expected = "/login";
        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }



}
