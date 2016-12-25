package ru.stqa.javaCursBarancev.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> befor = app.getGroupHelper().getGroupList();
    // int befor = app.getGroupHelper().getGroupCount();
    GroupData group = new GroupData("test1", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
   // int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), befor.size() + 1);

    //int max = 0;
    //for (GroupData g: after){
    //  if (g.getId() > max) {
    //    max = g.getId();
   //  }
   // }

    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    befor.add(group);
    Comparator<? super GroupData> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    befor.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(new HashSet<Object>(befor),new HashSet<Object>(after) );
    Assert.assertEquals(befor, after);
  }

}
