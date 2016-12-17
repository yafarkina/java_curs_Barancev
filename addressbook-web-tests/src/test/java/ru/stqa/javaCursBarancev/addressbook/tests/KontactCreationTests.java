package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

public class KontactCreationTests extends TestBase {

  @Test
  public void testKontactCreation() {
    app.getNavigationHelper().gotoKontactPage();
    app.getKontactHelper().fillKontactForm(new KontactData(
            "firstname",
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
            "address2",
            null));
    app.getKontactHelper().submitKontactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}
