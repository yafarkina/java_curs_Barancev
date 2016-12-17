package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

public class KontactCreationTests extends TestBase {

  @Test
  public void testKontactCreation() {
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

      app.getNavigationHelper().gotoHomePage();
  }
}
