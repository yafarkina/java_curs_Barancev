package ru.stqa.java_curs_Barancev;

public class MyRepeatUnitClass {

  public static void main(String[] args) {
    hello("word") ;
    hello("user") ;
    hello("me") ;

    int l=5;
    int s = square(l);
    System.out.println("площадь прямоугольника, со стороной " + l + " равна " + s);
  }

 public static void hello (String samebody){
   System.out.println("hello, " + samebody + "!");
 }

 public static int square (int l){
   int s=l*l;
   return s;
 }

}