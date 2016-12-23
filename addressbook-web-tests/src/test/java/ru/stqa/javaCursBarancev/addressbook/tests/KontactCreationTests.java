package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.HashSet;
import java.util.List;

public class KontactCreationTests extends TestBase {

  @Test
  public void testKontactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<KontactData> befor = app.getKontactHelper().getKontactList();
   // int befor = app.getKontactHelper().getKontactCount();
    app.getNavigationHelper().gotoKontactPage();
    KontactData kontact = new KontactData(
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
            null);
    app.getKontactHelper().createKontact(kontact ,true);
    app.getNavigationHelper().gotoHomePage();

    List<KontactData> after = app.getKontactHelper().getKontactList();
    //int after = app.getKontactHelper().getKontactCount();
    Assert.assertEquals(after.size(), befor.size() + 1);

    int max = 0;
    for (KontactData k: after){
      if (k.getId() > max) {
        max = k.getId();
      }
    }
    kontact.setId(max);
    befor.add(kontact);
    Assert.assertEquals(new HashSet<Object>(befor), new HashSet<Object>(after));
  }
}
