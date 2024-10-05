package TestCases;

import Base.BaseTest;
import Pages.CheckoutBasicInfo;
import Pages.Home;
import Pages.SingleCategoryPage;
import Pages.SummeryCart;
import org.testng.annotations.Test;

import java.io.IOException;

public class SingleCategoryPageTests extends BaseTest {

    public SingleCategoryPage singleCategoryPage;

    public static Home home;

    public  static SummeryCart summeryCart;

    public static CheckoutBasicInfo checkoutBasicInfo;



    @Test
    public void add_single_product_to_cart() throws IOException {
        home = new Home(driver);
        singleCategoryPage = new SingleCategoryPage(driver);
        summeryCart = new SummeryCart(driver);
        checkoutBasicInfo = new CheckoutBasicInfo(driver);

        singleCategoryPage.selectSpecificSingleProduct("");

    }

}
