package ru.stqa.java_curs_Barancev;

public class MyRepeatUnitClass {

  public static void main(String[] args) {

    Square s = new Square ();
    s.l=5;
    System.out.println("площадь квадрата, со стороной " + s.l + " равна " + square(s));

    Rectangle r = new Rectangle ();
    r.a=5;
    r.b=6;
    System.out.println("площадь прямоугольника, со сторонами " + r.a + " и "+ r.b + " равна " + square(r));
  }


 public static double square (Square s){
   return s.l * s.l;
 }

 public static double square (Rectangle r){
   return r.a * r.b;
 }
}