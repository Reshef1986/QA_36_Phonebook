package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    //    @BeforeMethod
//    public void preCondition(){
//        if(app.getHelperUser().isLogged()){
//            app.getHelperUser().logout();
//        }
//
//    }
    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i= random.nextInt(100);
        String email = "reshef1986"+i+"@gmail.com";

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,"Rr6146858!");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("reshefgamail.com","Rr6146858!");
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password format"));

    }
    @Test
    public void registrationWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("reshef@gamail.com","Rr1");
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password format"));

    }
    @Test
    public void registrationUserAlreadyExists(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("reshef1986@gmail.com","Rr6146858!");
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("User already exist"));

    }
//    @AfterMethod
//    public void poscondition(){
//        if(){
//            logout()
//        }
//    }

}