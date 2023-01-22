package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
pause(1000);
        type(By.cssSelector("input[placeholder='Name']"), contact.getName());
        type(By.cssSelector("input[placeholder='Last Name']"), contact.getLastName());
        pause(2000);
        type(By.cssSelector("input[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("input[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("input[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("input[placeholder='description']"), contact.getDescription());

    }

    public void submitContactForm() {
        //.add_form__2rsm2 button
        click(By.xpath("//b[text()='Save']"));
    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for(WebElement el: list){
            if(el.getText().equals(name)){
                return true;
            }

        }
        return false;
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for(WebElement el: list){
            if(el.getText().equals(phone)){
                return true;
            }

        }
        return false;

    }


    public boolean isContactAddedByEmail(String email) {
        System.out.println(email);
        List<WebElement> elements = wd.findElements(By.cssSelector("div[class='contact-item_card__2SOIM']"));
        for (WebElement cont:elements) {
            pause(200);
            cont.click();
            pause(500);
            WebElement elementWithEmail = wd.findElement(By.cssSelector("div[class='contact-item-detailed_card__50dTS'] "));
            if(elementWithEmail.getText().contains(email)){
                return true;
            }


        }
        return false;
    }
public  boolean isNamtFill(){
    List<WebElement> elements = wd.findElements(By.cssSelector("input[placeholder='Name']"));
    return elements.size()>0;
}
    public boolean negativContactTectEmptyFill(){

        if (isNamtFill()){
            return true;
        }
        return false;
    }
}