package ru.stqa.java_curs_Barancev;

/**
 * Created by yafar_000 on 05.12.2016.
 */
public class Rectangle {
  public double a;
  public double b;

  public Rectangle (double a, double b){
    this.a = a;
    this.b = b;
  }
  public double square (){
    return this.a * this.b;
  }
}
