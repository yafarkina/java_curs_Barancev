package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.javaCursBarancev.addressbook.model.EmailDataKontact;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.PersonalDataKontact;

import static ru.stqa.javaCursBarancev.addressbook.model.KontactData.*;

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


  public void fillKontactForm(KontactData kontactData) {
    // type(By.name("group"), KontactData.getNickname());
    type(By.name("nickname"), kontactData.getNickname());
    type(By.name("title"), kontactData.getTitle());
    type(By.name("company"), kontactData.getCompany());
    type(By.name("address"), kontactData.getAddress());
    type(By.name("mobile"), kontactData.getMobile());
    type(By.name("address2"), kontactData.getAddress2());
    type(By.name("notes"), kontactData.getNotes());
  }

  public void fillKontactEmail(EmailDataKontact emailDataKontact) {
    type(By.name("email"), emailDataKontact.getEmail());
    type(By.name("email2"), emailDataKontact.getEmail2());
    type(By.name("email3"), emailDataKontact.getEmail3());
  }

  public void fillKontactFIO(PersonalDataKontact resonalDataKontact) {
    type(By.name("firstname"), resonalDataKontact.getFirstname());
    type(By.name("middlename"), resonalDataKontact.getMiddlename());
    type(By.name("lastname"), resonalDataKontact.getLastname());
  }

  public void selectKontact() {
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
