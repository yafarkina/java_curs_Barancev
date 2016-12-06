package ru.stqa.java_curs_Barancev;

public class MyRepeatUnitClassMetod {

  public static void main(String[] args) {

    Square s = new Square (5);
    System.out.println("площадь квадрата, со стороной " + s.l + " равна " + s.square());

    Rectangle r = new Rectangle (4, 5);
    System.out.println("площадь прямоугольника, со сторонами " + r.a + " и "+ r.b + " равна " + r.square());
  }
}