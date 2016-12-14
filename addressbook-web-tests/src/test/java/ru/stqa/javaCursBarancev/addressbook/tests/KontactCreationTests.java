package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.EmailDataKontact;
import ru.stqa.javaCursBarancev.addressbook.model.PersonalDataKontact;

public class KontactCreationTests extends TestBase {

    @Test
    public void testKontactCreation() {
        app.getNavigationHelper().gotoKontactPage();
        app.getKontactHelper().fillKontactFIO(new PersonalDataKontact("first name", "middle name", "last name"));
        app.getKontactHelper().fillKontactNickname("nickname");
        app.getKontactHelper().fillKontactTitle("title");
        app.getKontactHelper().fillKontactCompany("company");
        app.getKontactHelper().fillKontactAddress("address");
        app.getKontactHelper().fillKontactMobile("+79999999999");
        app.getKontactHelper().fillKontactEmail(new EmailDataKontact("test1@test1.test1", "test2@test2.test2", "test3@.test3.test3"));
        app.getKontactHelper().fillKontactAddress2("address");
        app.getKontactHelper().fillKontactNotes("notes");
        app.getKontactHelper().submitKontactCreation();
        app.getNavigationHelper().gotoHomePage();
    }
}
