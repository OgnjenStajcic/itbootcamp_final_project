package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTestPage{


    @Test(priority = 1)
    public void signupPage(){
        homePage.signup();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/signup"));
    }


    @Test(priority = 2)
    public void inputTypes() throws InterruptedException {
        homePage.signup();
        String typeEmail = "email";
        String actTypeEmail = signupPage.getEmail().getAttribute("type");
        Assert.assertTrue(actTypeEmail.equals(typeEmail));
        String typePass = "password";
        String actTypePass = signupPage.getPassword().getAttribute("type");
        Assert.assertTrue(actTypePass.equals(typePass));
        String typeConfirm = "password";
        String actTypeConfirm = signupPage.getConfirm().getAttribute("type");
        Assert.assertTrue(actTypeConfirm.equals(typeConfirm));
    }




    @Test(priority = 3)
    public void displayErrors() throws InterruptedException {
        homePage.signup();
        signupPage.signUp("Test Test", "admin@admin.com", "123654", "123654");
        Thread.sleep(3000);
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]"));
        String expected = "E-mail already exists";
        Assert.assertTrue(closeBtn.getText().contains(expected));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/signup"));
    }


    //Test #4: Signup
    //Podaci:
    //name: Ime i prezime polaznika
    //email template: ime.prezime@itbootcamp.rs
    //password: 12346
    //confirm password: 123456
    //assert:
    //Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT:
    //Verify your account

//    @Test(priority = 4)
//    public void signup() throws InterruptedException {
//        homePage.signup();
//        signupPage.signUp("Ognjen Stajcic", "ognjen.stajcic@itbootcamp.rs", "12346", "12346");
//        Thread.sleep(1500);
//    }


}
