package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.Kontacts;

import java.util.List;

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

  public Kontacts getKontactCache() {
    return kontactCache;
  }

  public void fillKontactForm(KontactData kontactData, boolean creation) {
    type(By.name("firstname"), kontactData.getFirstname());
    type(By.name("middlename"), kontactData.getMiddlename());
    type(By.name("lastname"), kontactData.getLastname());
    type(By.name("nickname"), kontactData.getNickname());
    type(By.name("title"), kontactData.getTitle());
    type(By.name("company"), kontactData.getCompany());
    type(By.name("address"), kontactData.getAddress());
    type(By.name("home"), kontactData.getHomePhone());
    type(By.name("mobile"), kontactData.getMobilePhone());
    type(By.name("work"), kontactData.getWorkPhone());
    type(By.name("email"), kontactData.getEmail());
    type(By.name("email2"), kontactData.getEmail2());
    type(By.name("email3"), kontactData.getEmail3());
    type(By.name("address2"), kontactData.getAddress2());
    type(By.name("notes"), kontactData.getNotes());
    attach(By.name("photo"), kontactData.getPhoto());

    if (creation) {
      if (kontactData.getGroup() != null) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(kontactData.getGroup());
      } else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
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

  public void initKontactDetailsById(int id) {
    wd.findElement(By.cssSelector("a[href='" + "view.php?id=" + id + "']")).click();
  }

  public String veiwKontactDetails() {
    String veiwKontactDetails = wd.findElement(By.id("content")).getText();
    return veiwKontactDetails;
  }

  public void deleteSelectedKontact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void updateSelectedKontact() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(KontactData kontact, boolean creation) {
    fillKontactForm(kontact, creation);
    submitKontactCreation();
    kontactCache = null;
  }

  public void delete(KontactData kontact) {
    selectKontactById(kontact.getId());
    initKontactModificationById(kontact.getId());
    deleteSelectedKontact();
    kontactCache = null;
  }

  public void modify(KontactData kontact) {
    selectKontactById(kontact.getId());
    initKontactModificationById(kontact.getId());
    fillKontactForm(kontact, false);
    updateSelectedKontact();
    kontactCache = null;
  }

  public boolean isThereAKontact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getKontactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Kontacts kontactCache = null;

  public Kontacts all() {
    if (kontactCache != null) {
      return new Kontacts(kontactCache);
    }
    kontactCache = new Kontacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String address = cells.get(3).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      KontactData kontact = new KontactData().
              withId(id).
              withFirstname(firstname).
              withLastname(lastname).
              withAddress(address).
              withAllEmails(allEmails).
              withAllPhones(allPhones);

      kontactCache.add(kontact);
    }
    return new Kontacts(kontactCache);
  }


  public KontactData infoFromEditForm(KontactData kontact) {
    initKontactModificationById(kontact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPhone = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    String notes = wd.findElement(By.name("notes")).getAttribute("value");


    return new KontactData()
            .withId(kontact.getId())
            .withFirstname(firstname)
            .withMiddlename(middlename)
            .withLastname(lastname)
            .withAddress(address)
            .withNickname(nickname)
            .withCompany(company)
            .withTitle(title)
            .withHomePhone(homePhone)
            .withMobile(mobilePhone)
            .withWorkPhone(workPhone)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3)
            .withAddress2(address2)
            .withNotes(notes);
  }

}
