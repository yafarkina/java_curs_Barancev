package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().GroupPage();
    if (!app.Group().isThereAGroup()) {
      app.Group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Set<GroupData> befor = app.Group().all();
    GroupData deletedGroup = befor.iterator().next();
    app.Group().delete(deletedGroup);
    Set<GroupData> after = app.Group().all();
    Assert.assertEquals(after.size(), befor.size()-1);

    befor.remove(deletedGroup);
    Assert.assertEquals(after, befor);
  }

}
