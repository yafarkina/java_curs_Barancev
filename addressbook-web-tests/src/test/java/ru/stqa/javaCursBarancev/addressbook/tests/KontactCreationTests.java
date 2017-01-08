package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.Kontacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class KontactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validKontacts(){
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/листочек.png");
    list.add(new Object[] {new KontactData()
            .withFirstname("first_name")
            .withMiddlename("middlename")
            .withLastname("last_name")
            .withNickname("nickname")
            .withCompany("company")
            .withTitle("title")
            .withAddress("address")
            .withHomePhone("(8-333)33-33-33")
            .withMobile("+79999999999")
            .withWorkPhone("22 22 22")
            .withEmail("email@mail.mail")
            .withEmail2("email2@mail.mail")
            .withEmail3("email3@mail.mail")
            .withPhoto(photo)
            // .withGroup("test1")
            .withAddress2("address2")});

    list.add(new Object[] {new KontactData()
            .withFirstname("first_name2")
            .withMiddlename("middlename2")
            .withLastname("last_name2")
            .withNickname("nickname2")
            .withCompany("company2")
            .withTitle("title2")
            .withAddress("address")
            .withHomePhone("(8-333)33-33-33")
            .withMobile("+79999999999")
            .withWorkPhone("22 22 22")
            .withEmail("email@mail.mail")
            .withEmail2("email2@mail.mail")
            .withEmail3("email3@mail.mail")
            .withPhoto(photo)
            // .withGroup("test1")
            .withAddress2("address2")});

    list.add(new Object[] {new KontactData()
            .withFirstname("first_name3")
            .withMiddlename("middlename")
            .withLastname("last_name3")
            .withNickname("nickname3")
            .withCompany("company3")
            .withTitle("title3")
            .withAddress("address")
            .withHomePhone("(8-333)33-33-33")
            .withMobile("+79999999999")
            .withWorkPhone("22 22 22")
            .withEmail("email@mail.mail")
            .withEmail2("email2@mail.mail")
            .withEmail3("email3@mail.mail")
            .withPhoto(photo)
            // .withGroup("test1")
            .withAddress2("address2")});
    return list.iterator();
  }

  @Test(dataProvider = "validKontacts")
  public void testKontactCreation(KontactData kontact) {
    app.goTo().HomePage();
    Kontacts befor = app.Kontact().all();
    app.goTo().KontactPage();
    app.Kontact().create(kontact, false);
    app.goTo().HomePage();
    assertThat(app.Kontact().getKontactCount(), equalTo(befor.size() + 1));
    Kontacts after = app.Kontact().all();
    assertThat(after, equalTo
            (befor.withAdded(kontact.withId(after.stream().mapToInt(k -> k.getId()).max().getAsInt()))));
  }
}
