package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class KontactDeletionTests extends TestBase {

  @Test

  public void testKontactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getKontactHelper().selectKontact();
    app.getKontactHelper().initKontactModification();
    app.getKontactHelper().deleteSelectedKontact();
    app.getNavigationHelper().gotoHomePage();
  }

}
