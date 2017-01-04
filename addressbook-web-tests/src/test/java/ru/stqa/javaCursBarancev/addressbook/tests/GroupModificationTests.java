package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    Groups befor = app.Group().all();
    GroupData modifiedGroup = befor.iterator().next();
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).
            withName("test1").
            withHeader("test2").
            withFooter("test3");
    app.Group().modify(group);
    assertThat(app.Group().getGroupCount(), equalTo(befor.size()));
    Groups after = app.Group().all();
    assertThat(after, equalTo(befor.withOut(modifiedGroup).withAdded(group)));
  }
}
