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
  FirefoxDriver wd;

  private  NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void stop() {
    wd.quit();
  }

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  

  public void submitKontactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillKontactNotes(String notes) {
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(notes);
  }

  public void fillKontactAddress2(String address) {
   wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(address);
  }

  public void fillKontactEmail(EmailDataKontact emailDataKontact) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(emailDataKontact.getEmail());
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(emailDataKontact.getEmail2());
    wd.findElement(By.name("email3")).click();
   wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(emailDataKontact.getEmail3());
  }

  public void fillKontactMobile(String mobile) {
   wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(mobile);
  }

  public void fillKontactAddress(String address) {
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(address);
  }

  public void fillKontactCompany(String company) {
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(company);
  }

  public void fillKontactTitle(String title) {
   wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(title);
  }

  public void fillKontactNickname(String nickname) {
   wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(nickname);
  }

  public void fillKontactFIO(PersonalDataKontact resonalDataKontact) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
   wd.findElement(By.name("firstname")).sendKeys(resonalDataKontact.getFirstname());
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(resonalDataKontact.getMiddlename());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(resonalDataKontact.getLastname());
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
