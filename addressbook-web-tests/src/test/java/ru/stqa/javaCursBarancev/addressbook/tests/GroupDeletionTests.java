package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.Group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups befor = app.db().groups();
    GroupData deletedGroup = befor.iterator().next();
    app.goTo().GroupPage();
    app.Group().delete(deletedGroup);
    assertThat(app.Group().getGroupCount(), equalTo(befor.size() - 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(befor.withOut(deletedGroup)));
  }

}
