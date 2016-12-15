package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.javaCursBarancev.addressbook.model.EmailDataKontact;
import ru.stqa.javaCursBarancev.addressbook.model.PersonalDataKontact;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class KontactHelper extends HelperBase {

  public KontactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitKontactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillKontactNotes(String notes) {
    type(By.name("notes"), notes);
  }

  public void fillKontactAddress2(String address) {
    type(By.name("address2"), address);
  }

  public void fillKontactEmail(EmailDataKontact emailDataKontact) {
    type(By.name("email"), emailDataKontact.getEmail());
    type(By.name("email2"), emailDataKontact.getEmail2());
    type(By.name("email3"), emailDataKontact.getEmail3());
  }

  public void fillKontactMobile(String mobile) {
    type(By.name("mobile"), mobile);
  }

  public void fillKontactAddress(String address) {
    type(By.name("address"), address);
  }

  public void fillKontactCompany(String company) {
    type(By.name("company"), company);
  }

  public void fillKontactTitle(String title) {
    type(By.name("title"), title);
  }

  public void fillKontactNickname(String nickname) {
    type(By.name("nickname"), nickname);
  }

  public void fillKontactFIO(PersonalDataKontact resonalDataKontact) {
    type(By.name("firstname"), resonalDataKontact.getFirstname());
    type(By.name("middlename"), resonalDataKontact.getMiddlename());
    type(By.name("lastname"), resonalDataKontact.getLastname());
  }
  public void selectKontact () {
    click(By.name("selected[]"));
  }

 public void initKontactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[8]/a/img"));
 }

  public void deleteSelectedKontact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void updateSelectedKontact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }
}
