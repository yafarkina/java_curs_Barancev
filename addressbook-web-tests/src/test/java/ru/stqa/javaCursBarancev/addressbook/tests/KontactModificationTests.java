package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.PersonalDataKontact;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class KontactModificationTests extends TestBase {

  @Test

  public void testKontactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getKontactHelper().selectKontact();
    app.getKontactHelper().initKontactModification();
    app.getKontactHelper().fillKontactFIO(new PersonalDataKontact("name1", "middlename1", "lastname1"));
    app.getKontactHelper().fillKontactForm (new KontactData("nickname", "title", "company", "address", "+79999999999", "address2", "notes"));
    app.getKontactHelper().updateSelectedKontact();
    app.getNavigationHelper().gotoHomePage();
  }
}
