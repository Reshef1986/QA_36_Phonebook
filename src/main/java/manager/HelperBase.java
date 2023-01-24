package manager;

import org.openqa.selenium.*;
import org.testng.Assert;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text){

        WebElement element = wd.findElement(locator);
        if(text!=null){

            element.click();
            element.sendKeys(Keys.CONTROL+"a");
            element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys(text);
        }

        else {
            element.sendKeys(Keys.CONTROL+"a");
            element.sendKeys(Keys.BACK_SPACE);
        }

    }
    public void click(By locator){
        wd.findElement(locator).click();
    }

public void pause(int time){
    try {
        Thread.sleep(time);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    public boolean isErrorMessageDisplayed(String massage) {
        pause(500);
        Alert alert= wd.switchTo().alert();
        String text =alert.getText();
        System.out.println(text);

        // клик на кнопку  ок  ( 1 кнопка в алерте)
        pause(500);
        alert.accept();
        pause(500);
        return  text.contains(massage);
        //click cancel
        // alert.dismiss();

        // алерт с возможностью печатать нажать ок и кенсал
        //alert.sendKeys("Hello");

    }
}