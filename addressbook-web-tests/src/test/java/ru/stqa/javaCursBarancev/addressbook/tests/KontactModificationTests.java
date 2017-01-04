package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.Kontacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Kontacts befor = app.Kontact().all();
    KontactData modifiedKontact = befor.iterator().next();
    int index = befor.size()-1;
    KontactData kontact = new KontactData().
            withId(modifiedKontact.getId()).
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

    app.Kontact().modify(kontact);
    app.goTo().HomePage();

    Kontacts after = app.Kontact().all();
    assertThat(after.size(),equalTo( befor.size()));
    assertThat(after, equalTo(befor.withOut(modifiedKontact).withAdded(kontact)));
  }
}
