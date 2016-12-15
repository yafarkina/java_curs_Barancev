package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
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

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void deleteSelectedGroups() {
    clic(By.name("delete"));
  }

  public void selectGroup() {
    clic(By.name("selected[]"));
  }
}
