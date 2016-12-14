package ru.stqa.javaCursBarancev.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by yafar_000 on 14.12.2016.
 */
public class TestBase {

  protected final ApplicationManadger app = new ApplicationManadger();

  @AfterMethod

  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

}

