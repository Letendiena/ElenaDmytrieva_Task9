package ai.skillo.service;

import ai.skillo.data.Account;
import ai.skillo.pages.LoginPage;
import ai.skillo.pages.MainPage;
import ai.skillo.pages.MyAccountPage;
import ai.skillo.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class ProductService {

  public static MyAccountPage productDetailsPageProduct(WebDriver driver, Account account) {
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    return myAccountPage.open()
        .clickLogoButton();
  }
}