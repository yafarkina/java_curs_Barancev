package ru.stqa.javaCursBarancev.addressbook.tests;

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
public class KontactAddressTests extends TestBase {

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
                      withHomePhone("22-22-22-22").
                      withMobile("+79999999999").
                      withWorkPhone("33 33 33 33").
                      withEmail("email@mail.mail").
                      withEmail2("email2@mail.mail").
                      withEmail3("email3@mail.mail").
                      withGroup("test1").withAddress2("address2")
              , true);
      app.goTo().HomePage();
    }
  }

  @Test
  public void testKontactAddress() {
    KontactData kontact = app.Kontact().all().iterator().next();
    KontactData kontactInfoFromEditForm = app.Kontact().infoFromEditForm(kontact);
    app.goTo().HomePage();

    assertThat(kontact.getAddress(), equalTo(mergeAddress(kontactInfoFromEditForm)));
  }

  public String mergeAddress(KontactData kontact) {
   return kontact.getAddress();
   }


}
