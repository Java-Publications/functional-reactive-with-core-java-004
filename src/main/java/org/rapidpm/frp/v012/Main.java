package org.rapidpm.frp.v012;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

  static Function<String, BiFunction<Integer, Integer, Float>> operator() {
    return (operator) -> {
      BiFunction<Integer, Integer, Float> fkt = null;
      switch (operator) {
        case "+": fkt = (a , b) -> (float) (a + b); break;
        case "-": fkt = (a , b) -> (float) (a - b); break;
        case "/": fkt = (a , b) -> (float) (a / b); break;
        case "*": fkt = (a , b) -> (float) (a * b); break;
        default:
          throw new RuntimeException("bad op !!");
      }
      return fkt;
    };
  }

  public static void main(String[] args) {
    final Float result = operator().apply("+").apply(1 , 2);
    System.out.println("result = " + result);
  }
}
