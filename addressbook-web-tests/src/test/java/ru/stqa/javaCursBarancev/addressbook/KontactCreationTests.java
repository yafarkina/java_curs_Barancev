package ru.stqa.javaCursBarancev.addressbook;

import org.testng.annotations.Test;

public class KontactCreationTests extends TestBase {

    @Test
    public void testKontactCreation() {
        app.gotoKontactPage();
        app.fillKontactFIO(new PersonalDataKontact("first name", "middle name", "last name"));
        app.fillKontactNickname("nickname");
        app.fillKontactTitle("title");
        app.fillKontactCompany("company");
        app.fillKontactAddress("address");
        app.fillKontactMobile("+79999999999");
        app.fillKontactEmail(new EmailDataKontact("test1@test1.test1", "test2@test2.test2", "test3@.test3.test3"));
        app.fillKontactAddress2("address");
        app.fillKontactNotes("notes");
        app.submitKontactCreation();
        app.gotoHomePage();
    }
}
