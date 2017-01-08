package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;
import ru.stqa.javaCursBarancev.addressbook.model.Kontacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class KontactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validKontacts() throws IOException {
    File photo = new File("src/test/resources/листочек.png");
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/kontacts.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new KontactData()
              .withFirstname(split[0])
              .withMiddlename(split[1])
              .withLastname(split[2])
              .withNickname(split[3])
              .withCompany(split[4])
              .withTitle(split[5])
              .withAddress(split[6])
              .withHomePhone(split[7])
              .withMobile(split[8])
              .withWorkPhone(split[9])
              .withEmail(split[10])
              .withEmail2(split[11])
              .withEmail3(split[12])
              .withPhoto(photo)
              // .withGroup("test1")
              .withAddress2(split[13])});

      line = reader.readLine();
    }
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
