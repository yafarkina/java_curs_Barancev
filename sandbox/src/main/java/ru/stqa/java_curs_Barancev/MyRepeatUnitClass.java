package ru.stqa.java_curs_Barancev;

public class MyRepeatUnitClass {

  public static void main(String[] args) {
    hello("word") ;
    hello("user") ;
    hello("me") ;

    Square s = new Square ();
    s.l=5;
    System.out.println("площадь квадрата, со стороной " + s.l + " равна " + square(s));
  }

 public static void hello (String samebody){
   System.out.println("hello, " + samebody + "!");
 }

 public static double square (Square s){
   return s.l*s.l;
 }

}