package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.PersonalDataKontact;

public class KontactCreationTests extends TestBase {

  @Test
  public void testKontactCreation() {
    app.getNavigationHelper().gotoKontactPage();
    app.getKontactHelper().fillKontactFIO(new PersonalDataKontact("first name", "middle name", "last name"));
    app.getKontactHelper().fillKontactForm(new KontactData(
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
   // app.getKontactHelper().fillKontactEmail(new EmailDataKontact("test1@test1.test1", "test2@test2.test2", "test3@.test3.test3"));
    app.getKontactHelper().submitKontactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}
