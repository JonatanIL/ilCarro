package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {

    WebDriver wd;

    @BeforeTest
    public void preCondition() {
        //1.browser opens
        wd = new ChromeDriver();
        //2. open www
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        //  driver quit
        wd.quit();
    }


    public void openLoginForm() {
        wd.findElement(By.xpath("//a[@href='/login?url=%2Fsearch']")).click();
    }
    public void submitLogin() {
        wd.findElement(By.cssSelector("button[type='submit']")).click();
    }
    public void fillLoginForm(String email, String password) {
        // find +click+clear+sendKey
        type(By.cssSelector("#email"),email);
        // find +click+clear+sendKey
        type(By.cssSelector("#password"),password);

    }
    public void type(By locator,String text) {
        // find +click+clear+sendKey
        if(text!=null){
            WebElement element= wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }

}
