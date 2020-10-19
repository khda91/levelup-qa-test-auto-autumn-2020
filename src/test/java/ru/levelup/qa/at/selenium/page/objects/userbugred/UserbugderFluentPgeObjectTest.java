package ru.levelup.qa.at.selenium.page.objects.userbugred;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import ru.levelup.qa.at.selenium.AbstractBaseTest;
import ru.levelup.qa.at.selenium.page.objects.fluent.userbugred.UserBugredHomePage;
import ru.levelup.qa.at.selenium.page.objects.fluent.userbugred.UssrBugredLoginRegistrationPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserbugderFluentPgeObjectTest extends AbstractBaseTest {

    @Test
    public void registrationSuccessTest() {
        driver.get("http://users.bugred.ru/");
        UssrBugredLoginRegistrationPage loginRegistrationPage = new UserBugredHomePage(driver)
                .enterButtonClick();

        UserBugredHomePage homePage = loginRegistrationPage
                .fillRegistrationUserNameTextField(RandomStringUtils.randomAlphabetic(10))
                .fillRegistrationEmailTextField(RandomStringUtils.randomAlphabetic(5) + "@email.com")
                .fillRegistrationPasswordTextField("test")
                .successRegistrationButtonClick();

        assertThat(homePage.isUserButtonDisplayed(), is(true));
    }

    @Test
    public void registrationFailedTest() {
        driver.get("http://users.bugred.ru/");
        UssrBugredLoginRegistrationPage loginRegistrationPage = new UserBugredHomePage(driver)
                .enterButtonClick()
                .fillRegistrationUserNameTextField("testsddsasdjvkdashf")
                .fillRegistrationEmailTextField(RandomStringUtils.randomAlphabetic(5) + "@email.com")
                .fillRegistrationPasswordTextField("test")
                .failedRegistrationButtonClick();

        assertThat(loginRegistrationPage.getRegistrationErrorMessageText(), equalTo(""));
    }

}
