package ru.stqa.java_curs_Barancev;

public class MyRepeatUnitClass {

  public static void main(String[] args) {

    Square s = new Square (5);
    System.out.println("площадь квадрата, со стороной " + s.l + " равна " + square(s));

    Rectangle r = new Rectangle (4, 5);
    System.out.println("площадь прямоугольника, со сторонами " + r.a + " и "+ r.b + " равна " + square(r));
  }


 public static double square (Square s){
   return s.l * s.l;
 }

 public static double square (Rectangle r){
   return r.a * r.b;
 }
}