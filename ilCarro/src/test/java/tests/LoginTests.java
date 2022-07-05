package tests;

import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess(){
        int i =(int) (System.currentTimeMillis()/1000)%3600;
        User user = new User().setName("Lis").setLastName("Snow").setEmail("noa@gmail.com").setPassword("Nnoa12345$");
        
        app.getHelperUser().openLoginForm();

        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

    }
}