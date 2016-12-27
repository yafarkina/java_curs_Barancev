package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.List;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class KontactDeletionTests extends TestBase {

  @BeforeMethod

  public void insurePreconditions() {
    app.goTo().HomePage();
    if (!app.Kontact().isThereAKontact()) {
      app.goTo().KontactPage();
      app.Kontact().create(new KontactData(
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
              null),true);
      app.goTo().HomePage();
    }
  }

  @Test

  public void testKontactDeletion() {
    List<KontactData> befor = app.Kontact().List();
    int index = befor.size()-1;
    app.Kontact().delete(index);
    app.goTo().HomePage();

    List<KontactData> after = app.Kontact().List();
    Assert.assertEquals(after.size(), befor.size() - 1);

    befor.remove(index);
    Assert.assertEquals(after, befor);
  }



}
