package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SingleCategoryPage {
    // Webdriver
    public static WebDriver driver;
    // Locators

    public static List<WebElement> productLink;

    public SingleCategoryPage(WebDriver driver){
        this.driver=driver;
    }

    public void SelectRandomSingleProduct(){
        productLink = driver.findElements(By.xpath("//a[@data-testid='open_product-link']"));
        int size =productLink.size();
        System.out.println(size);
        Random random = new Random();
        int randomIndex = random.nextInt(size);
        WebElement randomProductLink = productLink.get(randomIndex);
        randomProductLink.click();
    }

    public void selectSpecificSingleProduct(String productName){
        productLink = driver.findElements(By.xpath("//a[@data-testid='open_product-link']"));
        for(WebElement product: productLink){
            if(product.getText().equals(productName)){
                product.click();
                return;
            }
        }
    }

}
