package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

import java.util.List;

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
    List<GroupData> befor = app.Group().List();
    app.Group().delete(befor);
    List<GroupData> after = app.Group().List();
    Assert.assertEquals(after.size(), befor.size()-1);

    befor.remove(befor.size()-1);
    Assert.assertEquals(after, befor);
  }

}
