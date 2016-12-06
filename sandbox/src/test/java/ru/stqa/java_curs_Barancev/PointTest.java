package ru.stqa.java_curs_Barancev;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by yafar_000 on 06.12.2016.
 */
@Test
public class PointTest {
  public void TestPoint (){
    Point x = new Point (4.0, 8.0);
    Point y = new Point (2.0, 6.0);
    Assert.assertEquals(x.distance(y),  5.656854249492381);
  }
}
