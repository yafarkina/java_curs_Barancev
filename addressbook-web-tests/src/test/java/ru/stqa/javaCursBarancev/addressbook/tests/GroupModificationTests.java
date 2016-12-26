package ru.stqa.javaCursBarancev.addressbook.tests;

import com.sun.corba.se.impl.orb.ParserTable;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
  }

  @Test
  public void testGroupModification() {

    List<GroupData> befor = app.getGroupHelper().getGroupList();
    int index = befor.size() - 1;
    GroupData group = new GroupData(befor.get(index).getId(),"test1", "test2", "test3");
    app.getGroupHelper().modifyGroup(index, group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), befor.size());

    befor.remove(index);
    befor.add(group);
    Comparator<? super GroupData> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    befor.sort(byId);
    after.sort(byId);
    Assert.assertEquals(befor, after);
  }



}
