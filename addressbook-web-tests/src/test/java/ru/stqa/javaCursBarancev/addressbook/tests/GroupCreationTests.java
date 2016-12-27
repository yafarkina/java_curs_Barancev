package ru.stqa.javaCursBarancev.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    List<GroupData> befor = app.Group().List();
    GroupData group = new GroupData("test1", null, null);
    app.Group().create(group);
    List<GroupData> after = app.Group().List();
    Assert.assertEquals(after.size(), befor.size() + 1);
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    befor.add(group);
    Comparator<? super GroupData> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    befor.sort(byId);
    after.sort(byId);
    Assert.assertEquals(befor, after);
  }

}
