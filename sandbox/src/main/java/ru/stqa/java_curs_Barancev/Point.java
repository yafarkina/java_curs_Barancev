package ru.stqa.java_curs_Barancev;

/**
 * Created by yafar_000 on 06.12.2016.
 */
public class Point {
  public double p1;
  public double p2;

  public Point(double p1, double p2) {
    this.p1 = p1;
    this.p2 = p2;
  }
  public double distance(Point otherPoint) {
    return Math.sqrt(Math.pow((this.p2 - this.p1), 2) + Math.pow((otherPoint.p2 - otherPoint.p1), 2));
  }
}
