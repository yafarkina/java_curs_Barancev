package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void selectKontact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  private void selectKontactById(int id) {
    wd.findElement(By.cssSelector("input[value ='" + id + "' ]")).click();
  }

 public void initKontactModification(int index) {
    wd.findElements(By.cssSelector("img[title='Edit']")).get(index).click();
   }

  public void initKontactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='" + "edit.php?id=" + id + "']")).click();
  }

  public void deleteSelectedKontact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void updateSelectedKontact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(KontactData kontact, boolean creation) {
   fillKontactForm(kontact,creation);
   submitKontactCreation();
   }

  public void delete(KontactData kontact) {
    selectKontactById(kontact.getId());
    initKontactModificationById(kontact.getId());
    deleteSelectedKontact();
  }

   public void modify(int index, KontactData kontact) {
    selectKontact(index);
    initKontactModification(index);
    fillKontactForm(kontact, false);
    updateSelectedKontact();
  }

  public void modify(KontactData kontact) {
    selectKontactById(kontact.getId());
    initKontactModificationById(kontact.getId());
    fillKontactForm(kontact, false);
    updateSelectedKontact();
  }

  public boolean isThereAKontact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getKontactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<KontactData> List() {
    List<KontactData> kontacts = new ArrayList<KontactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element: elements){
      List<WebElement> cells= element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      KontactData kontact = new KontactData().
              withId(id).
              withFirstname(firstname).
              withLastname(lastname).
              withAddress(address);

      kontacts.add(kontact);
    }
    return kontacts;
  }

  public Set<KontactData> all() {
    Set<KontactData> kontacts = new HashSet<KontactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element: elements){
      List<WebElement> cells= element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      KontactData kontact = new KontactData().
              withId(id).
              withFirstname(firstname).
              withLastname(lastname).
              withAddress(address);

      kontacts.add(kontact);
    }
    return kontacts;
  }


}
