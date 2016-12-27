package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class KontactModificationTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().HomePage();
    if (!app.Kontact().isThereAKontact()) {
      app.goTo().KontactPage();
      app.Kontact().create(new KontactData().
                      withFirstname("first_name").
                      withMiddlename("middlename").
                      withLastname("last_name").
                      withNickname("nickname").
                      withTitle("title").
                      withCompany("company").
                      withAddress("address").
                      withMobile("+79999999999").
                      withEmail("email@mail.mail").
                      withEmail2("email2@mail.mail").
                      withEmail3("email3@mail.mail").
                      withGroup("test1").withAddress2("address2")
              , true);
      app.goTo().HomePage();
    }
  }

  @Test

  public void testKontactModification() {
    List<KontactData> befor = app.Kontact().List();
    //int befor = app.Kontact().getKontactCount();
    int index = befor.size()-1;
    KontactData kontact = new KontactData().
            withId(befor.get(index).getId()).
            withFirstname("firstname2").
            withMiddlename("middlename").
            withLastname("lastname").
            withNickname("nickname").
            withTitle("title").
            withCompany("company").
            withAddress("address").
            withMobile("+79999999999").
            withEmail("email@mail.mail").
            withEmail2("email2@mail.mail").
            withEmail3("email3@mail.mail").
            withAddress2("address2").
            withNotes("notes");

    app.Kontact().modify(index, kontact);
    app.goTo().HomePage();

    List<KontactData> after = app.Kontact().List();
    //int after = app.Kontact().getKontactCount();
    Assert.assertEquals(after.size(), befor.size());

    befor.remove(index);
    befor.add(kontact);
    Comparator<? super KontactData> byId = (k1, k2) ->Integer.compare(k1.getId(), k2.getId());
    befor.sort(byId);
    after.sort(byId);
    Assert.assertEquals(befor, after);
   // Assert.assertEquals(new HashSet<Object>(befor), new HashSet<Object>(after));
  }
}
