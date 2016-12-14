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

  private final GroupHelper groupHelper = new GroupHelper();

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void stop() {
    groupHelper.wd.quit();
  }

  public void init() {
    groupHelper.wd = new FirefoxDriver();
    groupHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    groupHelper.wd.get("http://localhost/addressbook/group.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    groupHelper.wd.findElement(By.name("user")).click();
    groupHelper.wd.findElement(By.name("user")).clear();
    groupHelper.wd.findElement(By.name("user")).sendKeys(username);
    groupHelper.wd.findElement(By.name("pass")).click();
    groupHelper.wd.findElement(By.name("pass")).clear();
    groupHelper.wd.findElement(By.name("pass")).sendKeys(password);
    groupHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void gotoGroupPage() {
    groupHelper.wd.findElement(By.linkText("groups")).click();
  }

  public void gotoHomePage() {
    groupHelper.wd.findElement(By.linkText("home")).click();
  }

  public void submitKontactCreation() {
    groupHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillKontactNotes(String notes) {
    groupHelper.wd.findElement(By.name("notes")).click();
    groupHelper.wd.findElement(By.name("notes")).clear();
    groupHelper.wd.findElement(By.name("notes")).sendKeys(notes);
  }

  public void fillKontactAddress2(String address) {
    groupHelper.wd.findElement(By.name("address2")).click();
    groupHelper.wd.findElement(By.name("address2")).clear();
    groupHelper.wd.findElement(By.name("address2")).sendKeys(address);
  }

  public void fillKontactEmail(EmailDataKontact emailDataKontact) {
    groupHelper.wd.findElement(By.name("email")).click();
    groupHelper.wd.findElement(By.name("email")).clear();
    groupHelper.wd.findElement(By.name("email")).sendKeys(emailDataKontact.getEmail());
    groupHelper.wd.findElement(By.name("email2")).click();
    groupHelper.wd.findElement(By.name("email2")).clear();
    groupHelper.wd.findElement(By.name("email2")).sendKeys(emailDataKontact.getEmail2());
    groupHelper.wd.findElement(By.name("email3")).click();
    groupHelper.wd.findElement(By.name("email3")).clear();
    groupHelper.wd.findElement(By.name("email3")).sendKeys(emailDataKontact.getEmail3());
  }

  public void fillKontactMobile(String mobile) {
    groupHelper.wd.findElement(By.name("mobile")).click();
    groupHelper.wd.findElement(By.name("mobile")).clear();
    groupHelper.wd.findElement(By.name("mobile")).sendKeys(mobile);
  }

  public void fillKontactAddress(String address) {
    groupHelper.wd.findElement(By.name("address")).click();
    groupHelper.wd.findElement(By.name("address")).clear();
    groupHelper.wd.findElement(By.name("address")).sendKeys(address);
  }

  public void fillKontactCompany(String company) {
    groupHelper.wd.findElement(By.name("company")).click();
    groupHelper.wd.findElement(By.name("company")).clear();
    groupHelper.wd.findElement(By.name("company")).sendKeys(company);
  }

  public void fillKontactTitle(String title) {
    groupHelper.wd.findElement(By.name("title")).click();
    groupHelper.wd.findElement(By.name("title")).clear();
    groupHelper.wd.findElement(By.name("title")).sendKeys(title);
  }

  public void fillKontactNickname(String nickname) {
    groupHelper.wd.findElement(By.name("nickname")).click();
    groupHelper.wd.findElement(By.name("nickname")).clear();
    groupHelper.wd.findElement(By.name("nickname")).sendKeys(nickname);
  }

  public void fillKontactFIO(PersonalDataKontact resonalDataKontact) {
    groupHelper.wd.findElement(By.name("firstname")).click();
    groupHelper.wd.findElement(By.name("firstname")).clear();
    groupHelper.wd.findElement(By.name("firstname")).sendKeys(resonalDataKontact.getFirstname());
    groupHelper.wd.findElement(By.name("middlename")).click();
    groupHelper.wd.findElement(By.name("middlename")).clear();
    groupHelper.wd.findElement(By.name("middlename")).sendKeys(resonalDataKontact.getMiddlename());
    groupHelper.wd.findElement(By.name("lastname")).click();
    groupHelper.wd.findElement(By.name("lastname")).clear();
    groupHelper.wd.findElement(By.name("lastname")).sendKeys(resonalDataKontact.getLastname());
  }

  public void gotoKontactPage() {
    groupHelper.wd.findElement(By.linkText("add new")).click();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
