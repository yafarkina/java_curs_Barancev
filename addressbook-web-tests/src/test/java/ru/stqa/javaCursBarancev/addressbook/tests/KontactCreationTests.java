package ru.stqa.javaCursBarancev.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.Groups;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.Kontacts;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class KontactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    File photo = new File("src/test/resources/листочек.png");
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/kontacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<KontactData> kontacts = gson.fromJson(json, new TypeToken<List<KontactData>>() {
      }.getType());
      return kontacts.stream().map((k) -> new Object[]{k}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validKontactsFromXml() throws IOException {
    // File photo = new File("src/test/resources/листочек.png");
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/kontacts.xml")))) {

      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(KontactData.class);
      List<KontactData> kontacts = (List<KontactData>) xStream.fromXML(xml);
      return kontacts.stream().map((k) -> new Object[]{k}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validGroupsFromJson")
  public void testKontactCreation(KontactData kontact) {
    app.goTo().HomePage();
    Kontacts befor = app.db().kontacts();
    app.goTo().KontactPage();
    app.Kontact().create(kontact, false); //данные берутся из файла
    app.goTo().HomePage();
    assertThat(app.Kontact().getKontactCount(), equalTo(befor.size() + 1));
    Kontacts after = app.db().kontacts();
    assertThat(after, equalTo
            (befor.withAdded(kontact.withId(after.stream().mapToInt(k -> k.getId()).max().getAsInt()))));
  }

  @Test
  public void testKontactCreationWithGroup() {
    app.goTo().HomePage();
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.Group().create(new GroupData().withName("test1"));
    }
    Groups groups = app.db().groups();
    Kontacts befor = app.db().kontacts();
    app.goTo().KontactPage();
    File photo = new File("src/test/resources/листочек.png");
    KontactData  newKontact = new KontactData().
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
            inGroup(groups.iterator().next());

    app.Kontact().create(newKontact, true);
    app.goTo().HomePage();
    assertThat(app.Kontact().getKontactCount(), equalTo(befor.size() + 1));
    Kontacts after = app.db().kontacts();
    assertThat(after, equalTo
            (befor.withAdded(newKontact.withId(after.stream().mapToInt(k -> k.getId()).max().getAsInt()))));
  }
}
