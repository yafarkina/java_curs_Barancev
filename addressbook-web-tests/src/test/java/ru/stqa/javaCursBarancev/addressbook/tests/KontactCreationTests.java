package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.List;

public class KontactCreationTests extends TestBase {

  @Test
  public void testKontactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<KontactData> befor = app.getKontactHelper().getKontactList();
   // int befor = app.getKontactHelper().getKontactCount();
    app.getNavigationHelper().gotoKontactPage();
    app.getKontactHelper().createKontact(new KontactData(
            "ivan",
            "middlename",
            "ivan",
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

     app.getNavigationHelper().gotoHomePage();
    List<KontactData> after = app.getKontactHelper().getKontactList();
    //int after = app.getKontactHelper().getKontactCount();
    Assert.assertEquals(after.size(), befor.size() + 1);
  }
}
