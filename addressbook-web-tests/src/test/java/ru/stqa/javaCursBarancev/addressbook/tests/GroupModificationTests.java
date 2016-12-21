package ru.stqa.javaCursBarancev.addressbook.tests;

import com.sun.corba.se.impl.orb.ParserTable;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by yafar_000 on 15.12.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> befor = app.getGroupHelper().getGroupList();
    //int befor = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(befor.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(befor.get(befor.size() - 1).getId(),"test1", "test2", "test3");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
   // int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), befor.size());


    befor.remove(befor.size() - 1);
    befor.add(group);
    Assert.assertEquals(new HashSet<Object>(befor),new HashSet<Object>(after) );
  }

}
