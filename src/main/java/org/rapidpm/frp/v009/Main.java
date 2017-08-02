package org.rapidpm.frp.v009;

import java.util.function.Function;

/**
 *
 */
public class Main {

  public static void main(String[] args) {

    final Function<Integer, Integer> f1 = (x)-> x * 2;
    final Function<Integer, Integer> f2 = (x)-> x + 2;
    final Function<Integer, Integer> f3 = (x)-> x + 10;

    Main.<Integer, Integer, Integer>compose().apply(f2).apply(f1).apply(1);

    Main.<Integer, Integer, Integer>compose()
        .apply((x)-> x + 2)
        .apply((x)-> x * 2)
        .apply(1);

    Function<Integer, Integer> fx = Main.<Integer, Integer, Integer>compose()
        .apply((x)-> x + 2)
        .apply((x)-> x * 2);

    System.out.println("f1 f2 f3 (compose) => " + f1
        .compose((Function<Integer, Integer>)(x)-> x + 2)
        .compose((Function<Integer, Integer>)(x)-> x + 10)
        .apply(1));


    use(f1.compose((Function<Integer, Integer>)(x)-> x + 2)
          .compose((x)-> x + 10));


  }

  static void use(Function<Integer, Integer> f){
    System.out.println("f.apply(1) = " + f.apply(1));
  }

  static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> compose() {
    return (Function<U, V> f) -> (Function<T, U> g) -> (T x) -> f.apply(g.apply(x));
  }



}
