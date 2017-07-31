package org.rapidpm.frp.v008;

import java.util.function.Function;

/**
 *
 */
public class Main {

  public static void main(String[] args) {

    final Function<Integer, Integer> f1 = (x)-> x * 2;
//    final Function<Integer, Integer> f2 = (x)-> x + 2;
//    final Function<Integer, Integer> f3 = (x)-> x + 10;

    final Function<Integer, Integer>  fAndThen = f1.andThen((x)-> x + 2).andThen((x)-> x + 10);

//    final Function<Integer, Integer>  fCompose = f1.compose((x)-> x + 2).compose((x)-> x + 10);
    final Function<Integer, Integer>  fCompose = f1
        .compose((Function<Integer, Integer>) (x)-> x + 2)
        .compose((x)-> x + 10);

    System.out.println("f1 f2 f3 (andThen) => " + f1.andThen((x)-> x + 2).andThen((x)-> x + 10).apply(1));

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

}
