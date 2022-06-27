package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    WebDriver wd;

    @BeforeSuite
    public void setUp() {
        app.init();
    }


    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}



