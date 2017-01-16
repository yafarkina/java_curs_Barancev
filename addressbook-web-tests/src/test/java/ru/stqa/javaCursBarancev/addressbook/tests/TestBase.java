package ru.stqa.javaCursBarancev.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.javaCursBarancev.addressbook.appmanager.ApplicationManadger;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.Groups;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.Kontacts;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

  public void verifyGroupListUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.Group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g)-> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyKontactListUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Kontacts dbKontacts = app.db().kontacts();
      Kontacts uiKontacts = app.Kontact().all();
      assertThat(uiKontacts, equalTo(dbKontacts.stream()
              .map((k)-> new KontactData()
                      .withId(k.getId())
                      .withFirstname(k.getFirstname())
                      .withLastname(k.getLastname())
                      .withAddress(k.getAddress()))
              .collect(Collectors.toSet())));
    }
  }
}


