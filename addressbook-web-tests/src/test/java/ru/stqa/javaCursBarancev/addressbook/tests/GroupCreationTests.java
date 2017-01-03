package ru.stqa.javaCursBarancev.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Set<GroupData> befor = app.Group().all();
    GroupData group = new GroupData().withName("test1");
    app.Group().create(group);
    Set<GroupData> after = app.Group().all();
    Assert.assertEquals(after.size(), befor.size() + 1);
    group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    group.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt());
    befor.add(group);
    Assert.assertEquals(befor, after);
  }

}
