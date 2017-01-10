package ru.stqa.javaCursBarancev.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.javaCursBarancev.addressbook.appmanager.ApplicationManadger;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class TestBase {

  protected static final ApplicationManadger app
          = new ApplicationManadger(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }



}


