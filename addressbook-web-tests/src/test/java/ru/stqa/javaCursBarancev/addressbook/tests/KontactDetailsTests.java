package ru.stqa.javaCursBarancev.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.KontactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by yafar_000 on 07.01.2017.
 */
public class KontactDetailsTests extends TestBase {

  @BeforeMethod

  public void insurePreconditions() {
    app.goTo().HomePage();
    if (!app.Kontact().isThereAKontact()) {
      app.goTo().KontactPage();
      app.Kontact().create(new KontactData()
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
                    // withGroup("test1").
                      .withAddress2("address2")
              , false);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testKontactEmails() {
    app.goTo().HomePage();
    KontactData kontact = app.Kontact().all().iterator().next();
    KontactData kontactInfoFromEditForm = app.Kontact().infoFromEditForm(kontact);
    app.goTo().HomePage();
    app.Kontact().initKontactDetailsById(kontact.getId());

    String veiwKontactDetails = app.Kontact().veiwKontactDetails();

    assertThat(mergeKontactDataDetailsForm(veiwKontactDetails), equalTo(mergeKontactDataEditForm(kontactInfoFromEditForm)));
  }

 public String mergeKontactDataEditForm (KontactData kontact) {
    return Arrays
           .asList(kontact.getFirstname(),
                   kontact.getMiddlename(),
                   kontact.getLastname(),
                   kontact.getNickname(),
                   kontact.getTitle(),
                   kontact.getCompany(),
                   kontact.getAddress(),
                   kontact.getHomePhone(),
                   kontact.getMobilePhone(),
                   kontact.getWorkPhone(),
                   kontact.getEmail(),
                   kontact.getEmail2(),
                   kontact.getEmail3(),
                   kontact.getAddress2())
           .stream().filter(s -> !s.equals(""))
           .collect(Collectors.joining(" "));
 }

  public static String mergeKontactDataDetailsForm(String veiwKontactDetails) {
    return veiwKontactDetails.replaceAll("[HMW:]", "").replaceAll("\n\n", "\n").replaceAll("\n", " ").replaceAll("  ", " ");
  }

}
