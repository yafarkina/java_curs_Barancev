package ru.stqa.javaCursBarancev.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Groups befor = app.Group().all();
    GroupData group = new GroupData().withName("test1");
    app.Group().create(group);
    Groups after = app.Group().all();
    assertThat(after.size(), equalTo(befor.size() + 1));
    assertThat(after, equalTo(
            befor.withAdded(group.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }

}
