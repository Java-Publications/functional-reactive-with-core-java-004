package org.rapidpm.frp.v013;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.rapidpm.frp.model.Result;

/**
 *
 */
public class Main {

  static Function<String, Result<BiFunction<Integer, Integer, Float>>> operator() {
    return (operator) ->
        (operator.equals("+")) ? Result.success((a , b) -> (float) (a + b))
        : (operator.equals("-")) ? Result.success((a , b) -> (float) (a - b))
        : (operator.equals("/")) ? Result.success((a , b) -> (float) (a / b))
        : (operator.equals("*")) ? Result.success((a , b) -> (float) (a * b))
        : Result.failure("bad op !!");
  }


  public static void main(String[] args) {
    operator()
        .apply("+")
        .ifPresentOrElse(
            success -> System.out.println("result = " + success) ,
            failure -> System.out.println(failure)
        );
  }
}
