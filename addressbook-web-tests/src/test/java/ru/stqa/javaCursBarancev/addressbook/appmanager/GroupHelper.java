package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class GroupHelper {

  private FirefoxDriver wd;

  public GroupHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void initGroupCreation() {
    clic(By.name("new"));
  }

  public void returnToGroupPage() {
    clic(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    clic(By.name("submit"));
  }

  private void clic(By locator) {
    wd.findElement(locator).click();
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  private void type(By locator, String text) {
    clic(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void deleteSelectedGroups() {
    clic(By.name("delete"));
  }

  public void selectGroup() {
    clic(By.name("selected[]"));
  }
}
