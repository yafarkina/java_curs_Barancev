package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

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

  public void fillKontactForm(KontactData kontactData, boolean creation) {
    type(By.name("firstname"), kontactData.getFirstname());
    type(By.name("middlename"), kontactData.getMiddlename());
    type(By.name("lastname"), kontactData.getLastname());
    type(By.name("nickname"), kontactData.getNickname());
    type(By.name("title"), kontactData.getTitle());
    type(By.name("company"), kontactData.getCompany());
    type(By.name("address"), kontactData.getAddress());
    type(By.name("email"), kontactData.getEmail());
    type(By.name("email2"), kontactData.getEmail2());
    type(By.name("email3"), kontactData.getEmail3());
    type(By.name("mobile"), kontactData.getMobile());
    type(By.name("address2"), kontactData.getAddress2());
    type(By.name("notes"), kontactData.getNotes());

    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(kontactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void selectKontact() {
    click(By.name("selected[]"));
  }

  public void initKontactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void deleteSelectedKontact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void updateSelectedKontact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void createKontact(KontactData kontact, boolean creation) {
   fillKontactForm(kontact,creation);
    submitKontactCreation();
  }

  public boolean isThereAKontact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getKontactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
