package  tests;

import org.testng.annotations.Test;
import tests.TestBase;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noa@gmail.com","Nnoa12345$");
        app.getHelperUser().submitLogin();

    }

    @Test
    public void loginWrongEmail(){

    }
    @Test
    public void loginWrongPassword(){

    }
    @Test
    public void loginUnregisterUser(){

    }
}
