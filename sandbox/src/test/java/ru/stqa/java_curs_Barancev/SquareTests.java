package ru.stqa.java_curs_Barancev;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by yafar_000 on 06.12.2016.
 */

@Test

public class SquareTests {
  public void  TestSguare () {
    Square s = new Square(5);
    Assert.assertEquals(s.square(),25.0);
  }

}
