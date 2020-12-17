package ai.skillo.service;

import ai.skillo.data.Account;
import ai.skillo.pages.MainPage;
import ai.skillo.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class RegistrationService {

  public static RegistrationPage registerAccountPage(WebDriver driver, Account account) {
    MainPage mainPage = new MainPage(driver);
    return mainPage.open()
        .clickMyAccountButton()
        .clickRegistrationButton();
  }

  public static RegistrationPage registerAccount(WebDriver driver, Account account) {
    MainPage mainPage = new MainPage(driver);
    return mainPage.open()
        .clickMyAccountButton()
        .clickRegistrationButton()
        .inputFirstNameValue(account.getFirstName())
        .inputLastNameValue(account.getLastName())
        .inputEmailValue(account.getEmail())
        .inputPhoneValue(account.getPhone())
        .inputPasswordValue(account.getPassword())
        .inputConfirmPasswordValue(account.getPassword())
        .clickAgreeCheckBox()
        .clickContinueButton();
  }

  public static RegistrationPage privacyPolicyConfirmation(WebDriver driver, Account account) {
    MainPage mainPage = new MainPage(driver);
    return mainPage.open()
        .clickMyAccountButton()
        .clickRegistrationButton()
        .inputFirstNameValue(account.getFirstName())
        .inputLastNameValue(account.getLastName())
        .inputEmailValue(account.getEmail())
        .inputPhoneValue(account.getPhone())
        .inputPasswordValue(account.getPassword())
        .inputConfirmPasswordValue(account.getPassword())
        .clickContinueButton();
  }
}
