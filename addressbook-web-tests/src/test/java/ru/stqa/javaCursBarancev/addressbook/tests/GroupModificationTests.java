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
    if (app.db().groups().size() == 0){
      app.goTo().GroupPage();
      app.Group().create(new GroupData().withName("test1"));
    }
    }


  @Test
  public void testGroupModification() {

    Groups befor = app.db().groups();
    GroupData modifiedGroup = befor.iterator().next();
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).
            withName("test1").
            withHeader("test2").
            withFooter("test3");
    app.goTo().GroupPage();
    app.Group().modify(group);
    assertThat(app.Group().getGroupCount(), equalTo(befor.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(befor.withOut(modifiedGroup).withAdded(group)));
    verifyGroupListUI();
  }
}
