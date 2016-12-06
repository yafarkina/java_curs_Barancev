package ru.stqa.java_curs_Barancev;

public class MyClassDistanceBetweenTwoPoints {

  public static void main(String[] args) {

    Point x= new Point (4, 8);
    Point y= new Point(2, 6);
    System.out.println("расстояние между двумя точками " + " A" + "(" + x.p1 + "," + y.p1 +")" + " и " + "B" + "(" + x.p2 + "," + y.p2 + ") " + " равно " + x.distance());
  }

 }