package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.Comparator;
import java.util.List;

public class KontactCreationTests extends TestBase {

  @Test
  public void testKontactCreation() {
    app.goTo().HomePage();
    List<KontactData> befor = app.Kontact().List();
    app.goTo().KontactPage();
    KontactData kontact = new KontactData().
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
            withGroup("test1").
            withAddress2("address2");

    app.Kontact().create(kontact ,true);
    app.goTo().HomePage();

    List<KontactData> after = app.Kontact().List();
    Assert.assertEquals(after.size(), befor.size() + 1);

    kontact.withId(after.stream().max((k1, k2) -> Integer.compare(k1.getId(), k2.getId())).get().getId());
    befor.add(kontact);
    Comparator<? super KontactData> byId = (k1, k2) ->Integer.compare(k1.getId(), k2.getId());
    befor.sort(byId);
    after.sort(byId);
    Assert.assertEquals(befor, after);
    }
}
