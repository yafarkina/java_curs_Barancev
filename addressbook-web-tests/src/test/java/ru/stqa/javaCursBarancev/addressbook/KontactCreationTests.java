package ru.stqa.javaCursBarancev.addressbook;

import org.testng.annotations.Test;

public class KontactCreationTests extends TestBase {

    @Test
    public void testKontactCreation() {
        gotoKontactPage();
        fillKontactFIO(new PersonalDataKontact("first name", "middle name", "last name"));
        fillKontactNickname("nickname");
        fillKontactTitle("title");
        fillKontactCompany("company");
        fillKontactAddress("address");
        fillKontactMobile("+79999999999");
        fillKontactEmail(new EmailDataKontact("test1@test1.test1", "test2@test2.test2", "test3@.test3.test3"));
        fillKontactAddress2("address");
        fillKontactNotes("notes");
        submitKontactCreation();
        gotoHomePage();
    }

}
