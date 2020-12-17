package ai.skillo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

  WebDriver driver;

  public static final String SUCCESS_TITLE_VALUE = "Your Account Has Been Created!";

  @FindBy(xpath = "//input[@id = 'input-firstname']")
  private WebElement firstNameInput;

  @FindBy(xpath = "//input[@id = 'input-lastname']")
  private WebElement lastNameInput;

  @FindBy(xpath = "//input[@id = 'input-email']")
  private WebElement emailInput;

  private By phoneInputLocator = By.xpath("//input[@id = 'input-telephone']");
  private By passwordInputLocator = By.xpath("//input[@id = 'input-password']");
  private By confirmPasswordInputLocator = By.xpath("//input[@id = 'input-confirm']");
  private By agreeCheckboxInputLocator = By
      .xpath("//input[contains(@type, 'checkbox')  and  contains(@name, 'agree')] ");
  private By continueButtonLocator = By.xpath("//input[@value = 'Continue']");
  private By successTitleLocator = By.xpath("//*[@id = 'content']/h1[1]");
  private By registerAccountLocator = By.xpath("//div[@id = 'content']/h1");
  private By alertPrivacyPolicyLocator = By.xpath("//*[contains(@class, 'alert')]");

  public RegistrationPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public RegistrationPage inputFirstNameValue(String value) {
    firstNameInput.sendKeys(value);
    return this;
  }

  public RegistrationPage inputLastNameValue(String value) {
    lastNameInput.sendKeys(value);
    return this;
  }

  public RegistrationPage inputEmailValue(String value) {
    emailInput.sendKeys(value);
    return this;
  }

  public RegistrationPage inputPhoneValue(String value) {
    driver.findElement(phoneInputLocator).sendKeys(value);
    return this;
  }

  public RegistrationPage inputPasswordValue(String value) {
    driver.findElement(passwordInputLocator).sendKeys(value);
    return this;
  }

  public RegistrationPage inputConfirmPasswordValue(String value) {
    driver.findElement(confirmPasswordInputLocator).sendKeys(value);
    return this;
  }

  public RegistrationPage clickAgreeCheckBox() {
    driver.findElement(agreeCheckboxInputLocator).click();
    return this;
  }

  public RegistrationPage clickContinueButton() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(continueButtonLocator).click();
    return this;
  }

  public String getSuccessTitleValue() {
    return driver.findElement(successTitleLocator).getText();
  }

  public boolean isRegisterAccountDisplayed() {
    return driver.findElement(registerAccountLocator).isDisplayed();
  }

  public Boolean getAlertPrivacyPolicy() {
    return driver.findElement(alertPrivacyPolicyLocator).isDisplayed();
  }
}
