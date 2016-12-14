package ru.stqa.javaCursBarancev.addressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnToGroupPage();
    }

}
