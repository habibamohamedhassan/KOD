package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummeryCart {

    // Webdriver
    public static WebDriver driver;
    //Locators
    public static WebElement checkOutBTn;

    public SummeryCart(WebDriver driver ){
        this.driver=driver;
    }

    public void click_check_out_btn(){
        checkOutBTn = driver.findElement(By.xpath("//a[@data-testid='open_checkout-link']"));
        checkOutBTn.click();
    }

}
