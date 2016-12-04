package ru.stqa.java_curs_Barancev;

public class MyRepeatUnit {

  public static void main(String[] args) {
    hello("word") ;
    hello("user") ;
    hello("me") ;

    int l=5;
    System.out.println("площадь прямоугольника, со стороной " + l + " равна " + square(l));
  }

 public static void hello (String samebody){
   System.out.println("hello, " + samebody + "!");
 }

 public static int square (int l){
   int s=l*l;
   return s;
 }

}