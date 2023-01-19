package manager;

import model.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.util.List;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

   public void openLoginRegistrationForm(){
        click(By.xpath("//a[3]"));
    }

        public void fillLoginRegistrationForm(String email,String password){
        // for email
        type(By.cssSelector("[name='email']"),email);
        // for password
        type(By.cssSelector("[name='password']"),password);

    }

    public void submitLogin(){
        click(By.cssSelector("[name='login']"));

    }


    public boolean isLogged() {
       try {
            //return wd.findElement(By.xpath("//button")).isDisplayed();
        }catch (Exception e){
            return  false;
        }

        List<WebElement> list  = wd.findElements(By.xpath("//button[text()='Sign Out']"));

        return  list.size() > 0;
    }

    public void logOut() {
        click(By.xpath("//button"));
    }

    public boolean isErrorMessageDisplayed(String massage) {
     Alert alert= wd.switchTo().alert();
     String text =alert.getText();
        System.out.println(text);

        // клик на кнопку  ок  ( 1 кнопка в алерте)
        alert.accept();
        return  text.contains(massage);
        //click cancel
       // alert.dismiss();

        // алерт с возможностью печатать нажать ок и кенсал
        //alert.sendKeys("Hello");

    }

    public void submitRegistration() {
        click(By.cssSelector("[name ='registration']"));
    }

    public void login(String email,String password) {
    }

    public  void login(User user){
     openLoginRegistrationForm();
     fillLoginRegistrationForm(user.getEmail(), user.getPassword());
     submitLogin();

    }
}