package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class NavigationHelper extends HelperBase{

 public NavigationHelper(FirefoxDriver wd) {
    super(wd);


 }
 public void gotoGroupPage() {
    clic(By.linkText("groups"));
  }

  public void gotoHomePage() {

  clic(By.linkText("home"));
  }

  public void gotoKontactPage() {

  clic(By.linkText("add new"));
  }
}
