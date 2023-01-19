package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class HelperContact extends HelperBase{

    public HelperContact(WebDriver wd) {
        super(wd);
    }
public void openContactFormTabEntr() {
    pause(2000);
    Actions actions = new Actions(wd);

    for (int i = 0; i < 4; i++) {
        actions.sendKeys(Keys.TAB).release().perform();

    }

    actions.sendKeys(Keys.ENTER).release().perform();

}
    public void openContactForm() {
        click(By.cssSelector("a[href='/add']"));
    }

        //element.sendKeys(Keys.TAB);
   // element.sendKeys(Keys.LEFT);
   // element.sendKeys(Keys.ENTER);
    //wd.findElement(By.cssSelector("a[href='/contacts']"));
    //
       //click(By.cssSelector("..active"));
    //click(By.xpath("//a[normalize-space()='ADD']"));

public boolean isContactBoockOpen(){
        List<WebElement> list = wd.findElements(By.cssSelector("input[placeholder='Name']"));
return list.size() > 0;

    }
    public void fillAddContactForm(Contact [] contacts) {


        for (int i =0;i<contacts.length;i++){
            if (!isContactBoockOpen()){
                openContactForm();
            }
            type(By.cssSelector("input[placeholder='Name']"),contacts[i].getName());
            type(By.cssSelector("input[placeholder='Last Name']"),contacts[i].getLastName());
            type(By.cssSelector("input[placeholder='Phone']"),contacts[i].getPhone());
            type(By.cssSelector("input[placeholder='email']"),contacts[i].getEmail());
            type(By.cssSelector("input[placeholder='Address']"),contacts[i].getAddress());
            type(By.cssSelector("input[placeholder='description']"),contacts[i].getDescription());
         saveContact();
            pause(2000);
        }



        }

    public void saveContact() {

        click(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }

    public String getContactText (){

      return   wd.findElement(By.cssSelector(".contact-page_leftdiv__yhyke")).getText();

    }

    public void remoovContact() {


    }

}


