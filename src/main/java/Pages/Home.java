package Pages;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Home {
    // Driver
    public static WebDriver driver;
    // Nav menu items
    public static List<WebElement>  catsLinks;

    // Delivery menu
    public static WebElement closePanel;

    public static List<WebElement> Cities;
    public  static List<WebElement> Area;

    public static WebElement cartIconBtn;
    public static WebElement chooseDeliveryAreaBtn;

    // Variable

    public static List<String> CitiesNames = new ArrayList<>();

    public static String CitySearchName;



    public Home(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCartBtn(){
        cartIconBtn = driver.findElement(By.xpath("//button[@data-testid='open_cart-button']"));
        cartIconBtn.click();
    }
    public void selectRandomNavMenuItems() throws IOException {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
        //closePanel = driver.findElement(By.xpath("//span[contains(.,'Close panel')]/parent::button"));
        //closePanel.click();
        catsLinks=driver.findElements(By.xpath("//nav[@aria-label='Bottom']/child::ul/child::li/child::div/child::a"));
        int size = catsLinks.size();
        Random random =new Random();
        int randomIndex = random.nextInt(size);
        WebElement randomLink =catsLinks.get(randomIndex);
        randomLink.click();

    }

    // Select specific Category



    public  void  selectRandomDeliveryCity(){
        Cities = driver.findElements(By.xpath("//select[@id='selectCity']/child::option"));
        Cities.removeFirst();
        int size = Cities.size();
        Random random =new Random();
        int randomIndex = random.nextInt(size);
        WebElement randomLink =Cities.get(randomIndex);
        randomLink.click();


    }

    public  void selectRandomDeliveryAreas(){
        Area= driver.findElements(By.xpath("//select[@id='selectArea']/child::option"));
        int size = Area.size();
        Random random =new Random();
        int randomIndex = random.nextInt(size);
        WebElement randomLink =Area.get(randomIndex);
        randomLink.click();
    }

    // Select specific Delivery City
    public void selectSpecificCity(String CitySearchName) {
        List<WebElement> Cities = driver.findElements(By.xpath("//select[@id='selectCity']/child::option"));

        // Remove the first element if it's not needed
        if (!Cities.isEmpty()) {
            Cities.removeFirst();
        }

        // Loop through the Cities and select the one matching CitySearchName
        for (WebElement city : Cities) {
            if (city.getText().equals(CitySearchName)) {
                city.click(); // Click the city that matches CitySearchName
                System.out.println("City found and selected: " + CitySearchName);
                return; // Exit the method after selecting the city
            }
        }

        System.out.println("City not found: " + CitySearchName); // If the city is not found
    }

    public void selectSpecificArea(String AreaSearchName) {
        List<WebElement> Area = null;
        try {
            Area = driver.findElements(By.xpath("//select[@id='selectArea']/child::option"));

            // Loop through the area and select the one matching AreaSearchName
            for (WebElement area : Area) {
                if (area.getText().equals(AreaSearchName)) {
                    area.click(); // Click the area that matches AreaSearchName
                    System.out.println("Area found and selected: " + AreaSearchName);
                    return; // Exit the method after selecting the area
                }
            }

            System.out.println("Area not found: " + AreaSearchName); // If the area is not found
        } catch (StaleElementReferenceException e) {
            // Handle stale element reference by re-locating the elements and retrying
            System.out.println("Stale Element Reference Exception. Re-trying...");
            selectSpecificArea(AreaSearchName); // Recursively call the method to retry
        }
    }



    // Select Specific Delivery Branch
    public  void choseSpecificDeliveryBranch(){
        selectSpecificCity("المنصورة");
        selectSpecificArea("طلخة");
        chooseDeliveryAreaBtn =driver.findElement(By.cssSelector("button[class='w-full whitespace-nowrap rounded-lg bg-primary-300 px-8 py-4 text-center text-base font-medium text-white hover:bg-primary-400']"));
        chooseDeliveryAreaBtn.click();
    }

    // Select random Delivery Branch
    public void choseRandomDeliveryBranch(){
        selectRandomDeliveryAreas();
        selectRandomDeliveryAreas();
        chooseDeliveryAreaBtn =driver.findElement(By.cssSelector("button[class='w-full whitespace-nowrap rounded-lg bg-primary-300 px-8 py-4 text-center text-base font-medium text-white hover:bg-primary-400']"));
        chooseDeliveryAreaBtn.click();
    }

    public void test(){
        
    }



}
