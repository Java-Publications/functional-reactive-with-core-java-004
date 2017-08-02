package org.rapidpm.frp.v011;

import java.util.function.BiFunction;

/**
 *
 */
public class Main {


  public static BiFunction<Integer, Integer, Float> add = (a , b) -> (float) (a + b);
  public static BiFunction<Integer, Integer, Float> sub = (a , b) -> (float) (a - b);
  public static BiFunction<Integer, Integer, Float> div = (a , b) -> (float) (a / b);
  public static BiFunction<Integer, Integer, Float> mul = (a , b) -> (float) (a * b);


  static BiFunction<Integer, Integer, Float> operator(String operator) {
    BiFunction<Integer, Integer, Float> fkt = null;
    switch (operator) {
      case "+":
        fkt = add;
        break;
      case "-":
        fkt = sub;
        break;
      case "/":
        fkt = div;
        break;
      case "*":
        fkt = mul;
        break;
      default:
        throw new RuntimeException("bad op !!");
    }
    return fkt;
  }

  public static void main(String[] args) {
    final Float result = operator("+").apply(1 , 2);
    System.out.println("result = " + result);

  }

}
