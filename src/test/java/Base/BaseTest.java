package Base;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    // driver
    public static WebDriver driver;

    public static Properties properties = new Properties();
    public static FileReader fileReader;

    @BeforeMethod

    public void setUp() throws IOException
    {

        if(driver == null)
        {
             FileReader fileReader1 = new FileReader("src/test/resources/ConfigFiles/config.properties");
             properties.load(fileReader1);
            System.out.println("Hello1");
             

        }
        if  (properties.getProperty("browser").equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
            driver.get(properties.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            System.out.println("Hello chrome");

        }
        if (properties.getProperty("browser").equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
            driver.get(properties.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        }
        if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.get(properties.getProperty("url"));
        }


    }

    @AfterMethod

    public void tearDown()
    {
        driver.quit();
    }




}
