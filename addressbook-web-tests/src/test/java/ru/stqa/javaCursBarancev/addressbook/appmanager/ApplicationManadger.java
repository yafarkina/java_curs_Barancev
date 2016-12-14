package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.javaCursBarancev.addressbook.model.EmailDataKontact;
import ru.stqa.javaCursBarancev.addressbook.model.PersonalDataKontact;

import java.util.concurrent.TimeUnit;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class ApplicationManadger {

  private final NavigationHelper navigationHelper = new NavigationHelper();
  private GroupHelper groupHelper;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void stop() {
    navigationHelper.wd.quit();
  }

  public void init() {
    navigationHelper.wd = new FirefoxDriver();
    navigationHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    navigationHelper.wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(navigationHelper.wd);
    login("admin", "secret");
  }

  private void login(String username, String password) {
    navigationHelper.wd.findElement(By.name("user")).click();
    navigationHelper.wd.findElement(By.name("user")).clear();
    navigationHelper.wd.findElement(By.name("user")).sendKeys(username);
    navigationHelper.wd.findElement(By.name("pass")).click();
    navigationHelper.wd.findElement(By.name("pass")).clear();
    navigationHelper.wd.findElement(By.name("pass")).sendKeys(password);
    navigationHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void submitKontactCreation() {
    navigationHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillKontactNotes(String notes) {
    navigationHelper.wd.findElement(By.name("notes")).click();
    navigationHelper.wd.findElement(By.name("notes")).clear();
    navigationHelper.wd.findElement(By.name("notes")).sendKeys(notes);
  }

  public void fillKontactAddress2(String address) {
    navigationHelper.wd.findElement(By.name("address2")).click();
    navigationHelper.wd.findElement(By.name("address2")).clear();
    navigationHelper.wd.findElement(By.name("address2")).sendKeys(address);
  }

  public void fillKontactEmail(EmailDataKontact emailDataKontact) {
    navigationHelper.wd.findElement(By.name("email")).click();
    navigationHelper.wd.findElement(By.name("email")).clear();
    navigationHelper.wd.findElement(By.name("email")).sendKeys(emailDataKontact.getEmail());
    navigationHelper.wd.findElement(By.name("email2")).click();
    navigationHelper.wd.findElement(By.name("email2")).clear();
    navigationHelper.wd.findElement(By.name("email2")).sendKeys(emailDataKontact.getEmail2());
    navigationHelper.wd.findElement(By.name("email3")).click();
    navigationHelper.wd.findElement(By.name("email3")).clear();
    navigationHelper.wd.findElement(By.name("email3")).sendKeys(emailDataKontact.getEmail3());
  }

  public void fillKontactMobile(String mobile) {
    navigationHelper.wd.findElement(By.name("mobile")).click();
    navigationHelper.wd.findElement(By.name("mobile")).clear();
    navigationHelper.wd.findElement(By.name("mobile")).sendKeys(mobile);
  }

  public void fillKontactAddress(String address) {
    navigationHelper.wd.findElement(By.name("address")).click();
    navigationHelper.wd.findElement(By.name("address")).clear();
    navigationHelper.wd.findElement(By.name("address")).sendKeys(address);
  }

  public void fillKontactCompany(String company) {
    navigationHelper.wd.findElement(By.name("company")).click();
    navigationHelper.wd.findElement(By.name("company")).clear();
    navigationHelper.wd.findElement(By.name("company")).sendKeys(company);
  }

  public void fillKontactTitle(String title) {
    navigationHelper.wd.findElement(By.name("title")).click();
    navigationHelper.wd.findElement(By.name("title")).clear();
    navigationHelper.wd.findElement(By.name("title")).sendKeys(title);
  }

  public void fillKontactNickname(String nickname) {
   navigationHelper.wd.findElement(By.name("nickname")).click();
    navigationHelper.wd.findElement(By.name("nickname")).clear();
    navigationHelper.wd.findElement(By.name("nickname")).sendKeys(nickname);
  }

  public void fillKontactFIO(PersonalDataKontact resonalDataKontact) {
    navigationHelper.wd.findElement(By.name("firstname")).click();
    navigationHelper.wd.findElement(By.name("firstname")).clear();
   navigationHelper.wd.findElement(By.name("firstname")).sendKeys(resonalDataKontact.getFirstname());
    navigationHelper.wd.findElement(By.name("middlename")).click();
    navigationHelper.wd.findElement(By.name("middlename")).clear();
    navigationHelper.wd.findElement(By.name("middlename")).sendKeys(resonalDataKontact.getMiddlename());
    navigationHelper.wd.findElement(By.name("lastname")).click();
    navigationHelper.wd.findElement(By.name("lastname")).clear();
    navigationHelper.wd.findElement(By.name("lastname")).sendKeys(resonalDataKontact.getLastname());
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
