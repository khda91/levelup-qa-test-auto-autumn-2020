package ru.levelup.qa.at.taf.skeleton;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.levelup.qa.at.taf.skeleton.listeners.TestRunListener;
import ru.levelup.qa.at.taf.skeleton.services.driver.DriverSingleton;

@Listeners({TestRunListener.class})
public abstract class AbstractBaseTest {

    @BeforeMethod
    public void setUp() {
        DriverSingleton.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
