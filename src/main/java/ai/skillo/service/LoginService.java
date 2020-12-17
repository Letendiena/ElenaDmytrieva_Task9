package ai.skillo.service;

import ai.skillo.data.Account;
import ai.skillo.pages.LoginPage;
import ai.skillo.pages.MainPage;
import ai.skillo.pages.MyAccountPage;
import ai.skillo.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

  public static MyAccountPage loginAccountPage(WebDriver driver, Account account) {
    LoginPage loginPage = new LoginPage(driver);
    return loginPage.open()
        .inputEmailValue(account.getEmail())
        .inputPasswordValue(account.getPassword())
        .clickLoginButton();
  }

  public static MyAccountPage loginWrongAccountPage(WebDriver driver, Account account) {
    MainPage mainPage = new MainPage(driver);
    return mainPage.open()
        .clickMyAccountButton()
        .clickLogButton()
        .inputEmailValue(account.getEmail())
        .inputPasswordValue(account.getPassword())
        .clickLoginButton();
  }

  public static MyAccountPage logoutAccountPage(WebDriver driver, Account account) {
    LoginPage loginPage = new LoginPage(driver);
    return loginPage.open()
        .inputEmailValue(account.getEmail())
        .inputPasswordValue(account.getPassword())
        .clickLoginButton()
        .clickMyAccountButton()
        .clickLogoutButton();
  }

  public static MyAccountPage productDetailsPageMainLog(WebDriver driver, Account account) {
    LoginPage loginPage = new LoginPage(driver);
    return loginPage.open()
        .inputEmailValue(account.getEmail())
        .inputPasswordValue(account.getPassword())
        .clickLoginButton()
        .clickLogoButton()
        .clickProductName();
  }
}
