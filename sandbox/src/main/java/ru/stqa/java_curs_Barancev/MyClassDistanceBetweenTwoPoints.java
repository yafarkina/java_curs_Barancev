package ru.stqa.java_curs_Barancev;

public class MyClassDistanceBetweenTwoPoints {

  public static void main(String[] args) {

    Point x= new Point (4.0, 8.0);
    Point y= new Point(2.0, 6.0);
    System.out.println("расстояние между двумя точками " + " A" + "(" + x.p1 + "," + y.p1 +")" + " и " + "B" + "(" + x.p2 + "," + y.p2 + ") " + " равно " + x.distance(y));
  }

 }