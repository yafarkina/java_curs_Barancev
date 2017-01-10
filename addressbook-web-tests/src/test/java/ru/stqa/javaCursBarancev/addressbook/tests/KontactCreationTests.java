package ru.stqa.javaCursBarancev.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/kontacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<KontactData> groups = gson.fromJson(json, new TypeToken<List<KontactData>>() {
      }.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
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
      return kontacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validGroupsFromJson")
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
