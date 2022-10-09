package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTests extends BaseTestPage{

    //Test #1: Edits profile
    //Podaci: random podaci korišćenjem faker library-ja
    //assert:
    //Verifikovati da je prikazana poruka Profile saved successfuly
    //Verifikovati da svaki input sada za value atribut ima vrednost koja
    //je uneta u okviru forme

    @Test
    private void editProfile() throws InterruptedException {
        homePage.login();
        loginPage.login();
        profileTestsPage.getMyProfile().click();
        profileTestsPage.nameChange(profileTestsPage.getRandomName());
        profileTestsPage.phoneChange(profileTestsPage.getRandomPhone());
        profileTestsPage.cityChange();
        profileTestsPage.countryChange(profileTestsPage.getRandomCountry());
        profileTestsPage.twitterChange(profileTestsPage.getRandomTwitter());
        profileTestsPage.gitHubChange(profileTestsPage.getRandomGit());
        profileTestsPage.getSave().click();

//        String actual = profileTestsPage.getMsgBox().getText();
//        Assert.assertTrue(actual.contains("Profile saved successfuly"));

        String expctdName = profileTestsPage.getRandomName();
        String actualName = profileTestsPage.getName().getAttribute("value");
        Assert.assertEquals(actualName, expctdName);

        String expctdPhone = profileTestsPage.getRandomPhone();
        String actualPhone = profileTestsPage.getPhone().getAttribute("value");
        Assert.assertEquals(actualPhone, expctdPhone);

//        String expctdCity = profileTestsPage.getCity().getText();
//        String actualCity = profileTestsPage.getCity().getAttribute("value");
//        Assert.assertEquals(actualCity, expctdCity);

        String expctdCountry = profileTestsPage.getRandomCountry();
        String actualCountry = profileTestsPage.getCountry().getAttribute("value");
        Assert.assertEquals(actualCountry, expctdCountry);

        String expctdTwitter = profileTestsPage.getRandomTwitter();
        String actualTwitter = profileTestsPage.getTwitter().getAttribute("value");
        Assert.assertEquals(actualTwitter, expctdTwitter);

        String expctdGit = profileTestsPage.getRandomGit();
        String actualGit = profileTestsPage.getGitHub().getAttribute("value");
        Assert.assertEquals(actualGit, expctdGit);



    }

}
