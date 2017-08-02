package org.rapidpm.frp.v010;

/**
 *
 */
public class Main {

  public static interface Operator {
    public Float work(Integer a , Integer b);
  }

  public static final class Add implements Operator {
    @Override
    public Float work(Integer a , Integer b) {
      return (float) (a + b);
    }
  }

  public static final class Sub implements Operator {
    @Override
    public Float work(Integer a , Integer b) {
      return (float) (a - b);
    }
  }

  public static final class Mult implements Operator {
    @Override
    public Float work(Integer a , Integer b) {
      return (float) (a * b);
    }
  }

  public static final class Divide implements Operator {
    @Override
    public Float work(Integer a , Integer b) {
      return (float) (a / b);
    }
  }

  public static Operator operator(String op) {
    Operator result;
    switch (op) {
      case "+":
        result = new Add();
        break;
      case "-":
        result = new Sub();
        break;
      case "/":
        result = new Divide();
        break;
      case "*":
        result = new Mult();
        break;
      default:
        throw new RuntimeException("bad op");
    }
    return result;
  }


  public static void main(String[] args) {
    final Float result = operator("+").work(1 , 2);
    System.out.println("result = " + result);
  }

}
