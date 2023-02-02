package tests;

import manager.DataProviderUser;
import manager.ListenerTNG;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Listeners(ListenerTNG.class)
public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){

        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info(" I need logout");
        }

    }

    @DataProvider
    public Iterator<Object[]> loginData(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"reshef1986@gmail.com","Rr6146858!"});
        list.add(new Object[]{"reshef1986@gmail.com","Rr6146858!"});
        list.add(new Object[]{"reshef1986@gmail.com","Rr6146858!"});


        return list.iterator();

    }
    @Test (dataProvider ="loginData")
    public void loginSuccess(String email ,String password){

        logger.info("Login with valid data :  email: "+email +" & password: "+password);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Tests success");


    }

    @Test (dataProvider ="loginDataCls",dataProviderClass = DataProviderUser.class)
    public void loginSuccess2(String email ,String password){

        logger.info("Login with valid data :  email: "+email +" & password: "+password);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Tests success");


    }
    @Test (invocationCount = 2)
    public void loginSuccessNew(){

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("reshef1986@gmail.com","Rr6146858!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test (dataProvider ="loginDataUser",dataProviderClass = DataProviderUser.class)

    public void loginSuccessModel(User user){
logger.info("Test start  wheth user model ---->" + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test (dataProvider ="loginDataUserFromFile",dataProviderClass = DataProviderUser.class)

    public void loginSuccessModelFromFile(User user){
        logger.info("Test start  wheth user model ---->" + user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("reshef19186@gmail.com","Rr6146858!");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
        logger.info("Error message is : 'Wrong email or password' ");

    }
    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("reshef1986@gmail.com","Rr");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
    }
    @Test
    public void loginUnregisterUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("reshef19861@gmail.com","Rr6146858!1");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));

    }


}