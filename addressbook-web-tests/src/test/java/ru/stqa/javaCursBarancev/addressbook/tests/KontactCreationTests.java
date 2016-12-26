package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class KontactCreationTests extends TestBase {

  @Test
  public void testKontactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<KontactData> befor = app.getKontactHelper().getKontactList();
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
    Assert.assertEquals(after.size(), befor.size() + 1);

    kontact.setId(after.stream().max((k1, k2) -> Integer.compare(k1.getId(), k2.getId())).get().getId());
    befor.add(kontact);
    Comparator<? super KontactData> byId = (k1, k2) ->Integer.compare(k1.getId(), k2.getId());
    befor.sort(byId);
    after.sort(byId);
    Assert.assertEquals(befor, after);
    }
}
