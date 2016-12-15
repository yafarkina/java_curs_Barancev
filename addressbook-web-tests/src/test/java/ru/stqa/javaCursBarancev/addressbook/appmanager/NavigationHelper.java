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
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void gotoKontactPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}
