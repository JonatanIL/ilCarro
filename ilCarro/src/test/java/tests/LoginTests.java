package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void aLoginSuccess() {

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("jonataneitan@gmail.com", "Jonatan1986");
        app.getHelperUser().submitLogin();
        app.getHelperUser().submitButtonLogIn();

    }

    @Test
        public void zLoginNegativeTestsWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("jonataneitangmail.com", "Jonatan1986");
        app.getHelperUser().submitLogin();
    }

}
