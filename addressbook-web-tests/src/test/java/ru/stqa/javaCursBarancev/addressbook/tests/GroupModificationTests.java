package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

import java.util.Set;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().GroupPage();
    if (!app.Group().isThereAGroup()) {
      app.Group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {

    Set<GroupData> befor = app.Group().all();
    GroupData modifiedGroup = befor.iterator().next();
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).
            withName("test1").
            withHeader("test2").
            withFooter("test3");
    app.Group().modify(group);
    Set<GroupData> after = app.Group().all();
    Assert.assertEquals(after.size(), befor.size());

    befor.remove(modifiedGroup);
    befor.add(group);
    Assert.assertEquals(befor, after);
  }



}
