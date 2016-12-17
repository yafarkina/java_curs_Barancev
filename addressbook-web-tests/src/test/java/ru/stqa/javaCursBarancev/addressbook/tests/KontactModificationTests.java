package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class KontactModificationTests extends TestBase {

  @Test

  public void testKontactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getKontactHelper().selectKontact();
    app.getKontactHelper().initKontactModification();
    app.getKontactHelper().fillKontactForm(new KontactData(
            "firstname2",
            "middlename",
            "lastname",
            "nickname",
            "title",
            "company",
            "address",
            "+79999999999",
            "email@mail.mail",
            "email2@mail.mail",
            "email3@mail.mail",
            null,
            "address2",
            "notes"));
    app.getKontactHelper().updateSelectedKontact();
    app.getNavigationHelper().gotoHomePage();
  }
}
