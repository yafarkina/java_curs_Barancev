package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.Kontacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class KontactCreationTests extends TestBase {

  @Test
  public void testKontactCreation() {
    app.goTo().HomePage();
    Kontacts befor = app.Kontact().all();

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

    Kontacts after = app.Kontact().all();
    assertThat(after.size(), equalTo(befor.size() + 1));
    assertThat(after, equalTo
            (befor.withAdded(kontact.withId(after.stream().mapToInt(k -> k.getId()).max().getAsInt()))));
    }
}
