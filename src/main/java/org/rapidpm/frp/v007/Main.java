package org.rapidpm.frp.v007;

import java.util.function.Function;

/**
 *
 */
public class Main {

  public static void main(String[] args) {

    final Function<Integer, Integer> f1 = (x)-> x * 2;
    final Function<Integer, Integer> f2 = (x)-> x + 2;
    final Function<Integer, Integer> f3 = (x)-> x + 10;

    System.out.println("f1 f2 f3 (andThen) => " + f1.andThen(f2).andThen(f3).apply(1));

    System.out.println("f1 f2 f3 (compose) => " + f1.compose(f2).compose(f3).apply(1));

  }
}
