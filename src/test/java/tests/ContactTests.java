package tests;

import model.Contact;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactTests  extends  TestBase {
    @BeforeMethod
    public void preconditions() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(User.builder().email("reshef1986@gmail.com").password("Rr6146858!").build());
            app.getHelperContact().pause(2000);
        }

    }

    @Test
    public void addContactsSuccess() {
        Random random = new Random();

        Contact contact = Contact.builder()
                .name("Alexandr")
                .lastName("Zacharov")
                .phone("0527685645")
                .email("reshef122229862@gmail.com")
                .address("Ganarkis 9/53")
                .description("I don't know what this field is for")
                .build();
        Contact contact1 = Contact.builder()
                .name("Alexandr")
                .lastName("Petrov")
                .phone("0527685646")
                .email("reshef1922862@gmail.com")
                .address("Ganarkis 9/53")
                .description("I don't know what this field is for")
                .build();
        // app.getHelperContact().openContactFormTabEntr();
        // app.getHelperContact().openContactForm();
        app.getHelperContact().fillAddContactForm(new Contact[]{contact, contact1});
Assert.assertTrue(app.getHelperContact().getContactText().contains(contact.getName()));
        Assert.assertTrue(app.getHelperContact().getContactText().contains(contact.getPhone()));
        Assert.assertTrue(app.getHelperContact().getContactText().contains(contact1.getName()));
        Assert.assertTrue(app.getHelperContact().getContactText().contains(contact1.getPhone()));
    }

    @Test
    public void addContactSuccess() {
        Contact contact = Contact.builder()
                .name("Alex")
                .lastName("Z")
                .phone("0527576161")
                .email("reshef191862@gmail.com")
                .address("Ganarkis 9/53")
                .description("I don't know what this field is for")
                .build();

        app.getHelperContact().fillAddContactForm(new Contact[]{contact});
        Assert.assertTrue(app.getHelperContact().getContactText().contains(contact.getName()));
        Assert.assertTrue(app.getHelperContact().getContactText().contains(contact.getPhone()));

    }
/*

@AfterMethod

public void postCondition()  {

}
*/
}