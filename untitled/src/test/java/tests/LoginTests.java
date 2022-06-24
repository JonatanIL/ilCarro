package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void successLogin (){
    //3. open form
        openLoginForm();
        //4. fill form+valid data
fillLoginForm("jonataneitan@gmail.com", "Jonatan1986");
    // 5.submit login
        submitLogin();

    }

}
