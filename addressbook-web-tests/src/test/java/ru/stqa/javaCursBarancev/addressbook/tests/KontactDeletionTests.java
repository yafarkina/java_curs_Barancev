package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.Groups;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.Kontacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class KontactDeletionTests extends TestBase {

  @BeforeMethod

  public void insurePreconditions() {
    app.goTo().HomePage();
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.Group().create(new GroupData().withName("test1"));
      app.goTo().HomePage();
    }
    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/листочек.png");
    if (app.db().kontacts().size() == 0) {
      app.goTo().KontactPage();
      app.Kontact().create(new KontactData().
              withFirstname("firstname2").
              withMiddlename("middlename").
              withLastname("lastname").
              withNickname("nickname").
              withTitle("title").
              withCompany("company").
              withAddress("address").
              withHomePhone("33 33 33").
              withMobile("+71111199999").
              withWorkPhone("3344-222-222").
              withEmail("email@mail.mail").
              withEmail2("email2@mail.mail").
              withEmail3("email3@mail.mail").
              withAddress2("address2").
              withNotes("notes").
              withPhoto(photo).
              inGroup(groups.iterator().next()),
                            true);
      app.goTo().HomePage();
    }
  }

  @Test

  public void testKontactDeletion() {
    Groups groups = app.db().groups();
    Kontacts befor = app.db().kontacts();
    KontactData deletedKontact = befor.iterator().next().inGroup(groups.iterator().next());
    app.Kontact().delete(deletedKontact);
    app.goTo().HomePage();
    assertThat(app.Kontact().getKontactCount(), equalTo(befor.size() - 1));
    Kontacts after = app.db().kontacts();
    assertThat(after, equalTo(befor.withOut(deletedKontact)));
  }
}
