package ai.skillo.tests;

import ai.skillo.data.Account;
import ai.skillo.data.AccountFactory;
import ai.skillo.pages.MyAccountPage;
import ai.skillo.service.LoginService;
import ai.skillo.service.ProductService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest {

  private static WebDriver driver = null;

  private Account accountForLogin = AccountFactory.getAccountForLogin();

  @BeforeMethod
  public void initBrowser() {
    System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--ignore-ssl-errors=yes");
    options.addArguments("--ignore-certificate-errors");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
  }

  @Test
  public void confirmUserCanOpenProductDetails() {
    String titleValueProductPage = LoginService.productDetailsPageMainLog(driver, accountForLogin)
        .getProductNameProductPage();
    String titleValueMainPagePage = ProductService
        .productDetailsPageProduct(driver, accountForLogin)
        .getProductNameMainPageValue();
    Assert
        .assertEquals(titleValueProductPage, titleValueMainPagePage, "Page title is not correct!");
  }

  @AfterMethod
  public void closeBrowser() {
    driver.quit();
  }
}
