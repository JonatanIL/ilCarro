package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        WebElement loginTab = wd.findElement(By.xpath("//a[text()=' Log in ']"));
        loginTab.click();
    }

    public void submitLogin() {
        wd.findElement(By.cssSelector("button[type='submit']")).click();
    }


    public void fillLoginForm(String email, String password) {

        // find +click+clear+sendKey
        type(By.xpath("//input[@id='email']"), email);

        // find +click+clear+sendKey
        type(By.xpath("//input[@id='password']"), password);
    }

    public boolean isLogged() {
        // sign out present? --> logged
        List<WebElement> list = wd.findElements(By.xpath("//a[@href='/logout?url=%2Fsearch']"));
        return list.size() > 0;
    }

    public void logout() {
        click(By.xpath("//a[@href='/logout?url=%2Fsearch']"));
    }

    public void submitButtonLogIn() {
        click(By.xpath("//button[@class='positive-button ng-star-inserted']"));
    }
}