package TestPackage;

import PageClasses.*;
import com.Grid.Lamdatest;
import com.Grid.MultiBrowser;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;

public class TestClass extends BaseClass {
    public LoginPage loginPage;
    public GearAndBagsPage gearAndBagsPage;
    public HighestPrice highestPrice;
    public WishListPage wishListPage;
   public ShippingAdressPage shippingAdressPage;
    public PayMentPage payMentPage;
    public ThankYoupage thankYoupage;
   public MultiBrowser multiBrowser;
   public Lamdatest lamdatest;


    @BeforeClass
    public void driverIntialization()
    {
        loginPage=new LoginPage(driver);
        gearAndBagsPage=new GearAndBagsPage(driver);
        highestPrice=new HighestPrice(driver);
        wishListPage=new WishListPage(driver);
        shippingAdressPage=new ShippingAdressPage(driver);
        payMentPage=new PayMentPage(driver);
        thankYoupage=new ThankYoupage(driver);

        multiBrowser=new MultiBrowser();
        lamdatest=new Lamdatest();
    }

    @Test
   public void allMethods() throws InterruptedException, FileNotFoundException {
        loginPage.login("kakarlakalyani123@gmail.com","Kalyani@123");
        gearAndBagsPage.gearAndBag();
        highestPrice.addToCart();
        String text=highestPrice.addtoCartText();
        Assert.assertEquals(text,"You have no items in your shopping cart.");//verifying the empty cart

        highestPrice.highestPrice();
        int hprice=highestPrice.highestPrice();
        highestPrice.highestItemName(hprice);
        String  itemWithHighPrice = highestPrice.highestItemName(hprice);
        highestPrice.wishList(hprice);
        String actualItemOnWishList=wishListPage.verifyingWishListPage();
        System.out.println(actualItemOnWishList);
        Assert.assertEquals(itemWithHighPrice,actualItemOnWishList);//verifying the itemname on wishList
        wishListPage.verifyingWishListPage();
        wishListPage.wishListAddtoCartButton();
      String actualErrorMessage= wishListPage.errorMessage();
       System.out.println(actualErrorMessage);
      //Assert.assertEquals(actualErrorMessage,"You have no items in your wish list.");//verifying the error message
      wishListPage.addtoCart();
     wishListPage.proceedtoCheckoutclick();
     shippingAdressPage.shippingAdressdata();
     shippingAdressPage.readingFileFromJson();
     payMentPage.payment();
    String actualdate= payMentPage.returnCurrentdate();
    //Assert.assertEquals(actualdate,"February 28, 2023");//verifying the current date
        WebElement orderNumber=thankYoupage.ordernumber();
        orderNumber.isDisplayed();//verifying order nuber generated or not
    multiBrowser.setUpBroser("edge");
    lamdatest.setUpBroser("edge");











    }

}
