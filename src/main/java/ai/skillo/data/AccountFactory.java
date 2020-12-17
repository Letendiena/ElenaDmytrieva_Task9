package ai.skillo.data;

import net.bytebuddy.utility.RandomString;

public class AccountFactory {

  private static RandomString random = new RandomString();

  private static final String LOGIN_EMAIL = "Elena@gmail.com";
  private static final String LOGIN_PASSWORD = "112233";

  private static final String FIRST_NAME = "John" + random.make(2);
  private static final String LAST_NAME = "Smith" + random.make(2);
  private static final String EMAIL = random.make(5) + "@mail.com";
  private static final String PHONE = "1234567";
  private static final String PASSWORD = "qwerty";

  public static Account getAccountForRegistration() {
    Account account = new Account(FIRST_NAME, LAST_NAME, EMAIL, PHONE, PASSWORD);
    return account;
  }

  public static Account getAccountForLogin() {
    Account account = new Account(LOGIN_EMAIL, LOGIN_PASSWORD);
    return account;
  }

  public static Account getAccountForWrongLogin() {
    Account account = new Account(EMAIL, PASSWORD);
    return account;
  }
}
