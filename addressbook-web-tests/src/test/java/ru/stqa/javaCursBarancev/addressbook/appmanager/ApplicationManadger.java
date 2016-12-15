package ru.stqa.javaCursBarancev.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class ApplicationManadger {
  FirefoxDriver wd;

  private KontactHelper kontactHelper;
  private  NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;

  public void stop() {
    wd.quit();
  }

  public void init() {
    wd = new FirefoxDriver();
   wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    kontactHelper = new KontactHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public KontactHelper getKontactHelper() {
    return kontactHelper;
  }
}
