package ru.stqa.javaCursBarancev.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.javaCursBarancev.addressbook.appmanager.ApplicationManadger;
import sun.plugin.dom.exception.BrowserNotSupportedException;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class TestBase {

  protected final ApplicationManadger app;

  public TestBase() {
    app = new ApplicationManadger(BrowserType.FIREFOX);
  }

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }



}


