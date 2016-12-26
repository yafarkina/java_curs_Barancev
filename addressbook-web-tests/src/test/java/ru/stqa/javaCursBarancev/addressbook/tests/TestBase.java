package ru.stqa.javaCursBarancev.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.javaCursBarancev.addressbook.appmanager.ApplicationManadger;
import sun.plugin.dom.exception.BrowserNotSupportedException;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class TestBase {

  protected static final ApplicationManadger app = new ApplicationManadger(BrowserType.FIREFOX);;

  //public TestBase() {
  //  app = new ApplicationManadger(BrowserType.FIREFOX);
  //}

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }



}


