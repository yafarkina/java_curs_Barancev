package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.javaCursBarancev.addressbook.model.EmailDataKontact;
import ru.stqa.javaCursBarancev.addressbook.model.PersonalDataKontact;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class KontactHelper extends HelperBase{

   public KontactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitKontactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillKontactNotes(String notes) {
     type(By.name("notes"), notes);
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
}
