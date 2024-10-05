package TestCases;

import Base.BaseTest;
import Pages.Home;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HomePageTests extends BaseTest {

    public static List<WebElement> catsLinks;
    public static List<WebElement> newCats;

    public static Home home;
    @Test

    public void getTitle() throws IOException {
        home = new Home(driver);
        home.choseSpecificDeliveryBranch();

    }



}
