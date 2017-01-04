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
    app.goTo().GroupPage();
    if (!app.Group().isThereAGroup()) {
      app.Group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Groups befor = app.Group().all();
    GroupData deletedGroup = befor.iterator().next();
    app.Group().delete(deletedGroup);
    Groups after = app.Group().all();
    assertThat(after.size(), equalTo(befor.size()-1));
    assertThat(after, equalTo(befor.withOut(deletedGroup)));
  }

}
