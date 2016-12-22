package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.List;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class KontactDeletionTests extends TestBase {

  @Test

  public void testKontactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getKontactHelper().isThereAKontact()) {
      app.getNavigationHelper().gotoKontactPage();
      app.getKontactHelper().createKontact(new KontactData(
              "first_name",
              "middlename",
              "last_name",
              "nickname",
              "title",
              "company",
              "address",
              "+79999999999",
              "email@mail.mail",
              "email2@mail.mail",
              "email3@mail.mail",
              "test1",
              "address2",
              null),true);
    }
    List<KontactData> befor = app.getKontactHelper().getKontactList();
    //int befor = app.getKontactHelper().getKontactCount();
    app.getKontactHelper().selectKontact(befor.size() - 1);
    app.getKontactHelper().initKontactModification();
    app.getKontactHelper().deleteSelectedKontact();
    app.getNavigationHelper().gotoHomePage();
    List<KontactData> after = app.getKontactHelper().getKontactList();
    //int after = app.getKontactHelper().getKontactCount();
    Assert.assertEquals(after.size(), befor.size() - 1);

    befor.remove(befor.size() - 1);
    Assert.assertEquals(after, befor);
  }

}
