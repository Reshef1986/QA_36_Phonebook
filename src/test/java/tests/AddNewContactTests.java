package tests;


import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(User.builder().email("reshef1986@gmail.com").password("Rr6146858!").build());
        }
    }

    @Test
    public void addContactSuccessAllFields() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Sasha" + i)
                .lastName("Zakharov")
                .address("BH")
                .phone("0521516" + i)
                .email("reshef1" + i + "@gmail")
                .description("The best friend").build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
        Assert.assertTrue(app.helperContact().isContactAddedByEmail(contact.getEmail()));


    }

    @Test
    public void addContactSuccessRequiredFields() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Zalman1" + i)
                .lastName("Simpson")
                .address("RT")
                .phone("0506967" + i)
                .email("reshef2" + i + "@gmail")
                .build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
        // Home Work
        Assert.assertTrue(app.helperContact().isContactAddedByEmail(contact.getEmail()));


    }

    @Test
    public void addContactEmptyName() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("")
                .lastName("Simpson2")
                .address("RT")
                .phone("0506967" + i)
                .email("reshef2" + i + "@gmail")
                .build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        app.getHelperUser().pause(500);
        Assert.assertTrue(app.helperContact().negativContactTectEmptyFill());
        app.getHelperUser().pause(500);
        Assert.assertTrue(!app.helperContact().isContactAdded());

    }

    @Test
    public void addContactEmptylastName() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
              //  .name("Zalman1986" + i)
                .name("Zalman1")
                .lastName("")

                .address("RT")
                .phone("0506967" + i)
                .email("reshef2" + i + "@gmail")
                .build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        app.getHelperUser().pause(500);
        Assert.assertTrue(app.helperContact().negativContactTectEmptyFill());
        app.getHelperUser().pause(500);
        Assert.assertTrue(!app.helperContact().isContactAdded());
    }
    @Test
    public void addContactWrongPhone() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Zalman1" + i)
                .lastName("Simpson")
                .address("RT")
                .phone("0507" )
                .email("reshef2" + i + "@gmail")
                .build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        app.getHelperUser().pause(500);
  Assert.assertTrue(app.helperContact().isErrorMessageDisplayed("Phone not valid: Phone number must contain only digits! And length min 10, max 15"));


    }
    @Test
    public void addContactWrongEmail() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Zalman1" + i)
                .lastName("Simpson")
                .address("RT")
                .phone("0507" )
                .email("reshef2" + i + "gmail")
                .build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        app.getHelperUser().pause(500);
        Assert.assertTrue(app.helperContact().isErrorMessageDisplayed("Email not valid: должно иметь формат адреса электронной почты"));

    }
    @Test(enabled=false)
    public void addContactEmptyAddres() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Zalman1" + i)
                .lastName("Simpson")
                .address("")
                .phone("0506967" + i)
                .email("reshef2" + i + "@gmail")
                .build();
        System.out.println(contact.toString());

        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().submitContactForm();
        app.getHelperUser().pause(500);
        Assert.assertTrue(app.helperContact().negativContactTectEmptyFill());
        app.getHelperUser().pause(500);
        Assert.assertTrue(!app.helperContact().isContactAdded());

    }

}


