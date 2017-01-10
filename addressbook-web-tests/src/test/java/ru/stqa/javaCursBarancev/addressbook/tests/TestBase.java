package ru.stqa.javaCursBarancev.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.javaCursBarancev.addressbook.appmanager.ApplicationManadger;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManadger app
          = new ApplicationManadger(System.getProperty("browser", BrowserType.FIREFOX));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @BeforeMethod
  public  void logTestStart(Method m, Object[] p){
    logger.info("Start test " + m.getName() + "with parametrs" + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p){
    logger.info("Stop test " + m.getName()+ "with parametrs" + Arrays.asList(p));
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


}


