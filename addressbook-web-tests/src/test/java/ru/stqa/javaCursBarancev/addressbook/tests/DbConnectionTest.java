package ru.stqa.javaCursBarancev.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.javaCursBarancev.addressbook.model.GroupData;
import ru.stqa.javaCursBarancev.addressbook.model.Groups;

import java.sql.*;

/**
 * Created by yafar_000 on 11.01.2017.
 */
public class DbConnectionTest {

  @Test
  public void testDbConnection() {
    Connection conn = null;

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?serverTimezone=UTC&user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select * from group_list");
      Groups groups = new Groups();
      while (rs.next()) {
        groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(groups);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
