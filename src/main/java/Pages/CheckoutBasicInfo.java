package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutBasicInfo {

    // Webdriver
    public static WebDriver driver;


    // Locators

    public static WebElement completeOrderBtn;

    public static WebElement firstName;

    public static WebElement lastName;

    public static WebElement mobileNumber;

    public static WebElement Email;

    public static WebElement sameDayDelivery;

    public static WebElement choseDeliveryDate;

    public static WebElement deliveryCity;

    public static WebElement deliveryArea;

    public static WebElement street;

    public static WebElement villa;

    public static WebElement apartment;

    public static WebElement buildingNo;

    public static WebElement floorNumber;

    public static WebElement apartmentNumber;

    public CheckoutBasicInfo(WebDriver driver){
        this.driver=driver;
    }


    public void submit_Basic_Data(){
        firstName = driver.findElement(By.xpath("//input[@data-testid='first_name-input']"));
        firstName.sendKeys("test");

        lastName = driver.findElement(By.xpath("//input[@data-testid='last_name-input']"));
        lastName.sendKeys("Support");

        mobileNumber = driver.findElement(By.xpath("//input[@data-testid='phone-input']"));
        mobileNumber.sendKeys("01013721034");

        Email = driver.findElement(By.xpath("//input[@data-testid='email-input']"));
        Email.sendKeys("testmitchdesigns@gmail.com");

        sameDayDelivery = driver.findElement(By.xpath("//label[@for='deliver_today']"));
        sameDayDelivery.submit();
        

        


    }


}
