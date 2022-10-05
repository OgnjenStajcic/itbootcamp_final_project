package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTestPage{


    @Test(priority = 1)
    public void signupPage(){
        homePage.signup();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/signup"));
    }




}
