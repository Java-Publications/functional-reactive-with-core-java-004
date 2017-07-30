package org.rapidpm.frp.v001;

import java.util.stream.Stream;

import org.rapidpm.frp.model.Quint;

public class Main {

  public enum Colour {
    UNDEFINED,
    BLUE,
    RED,
    WHITE,
    GREEN
  }

  public static class Car extends Quint<String, Colour, Integer, Integer, Float> {
    public Car(String brand , Colour colour , Integer speed , Integer year , Float price) {
      super(brand , colour , speed , year , price);
    }

    public String brand() {return getT1();}

    public Colour colour() {return getT2();}

    public Integer speed() {return getT3();}

    public Integer year() {return getT4();}

    public Float price() {return getT5();}
  }


  public static void main(String[] args) {
    Stream
        .of(
            new Car("BMW" , Colour.BLUE , 200 , 2017 , 10000f) ,
            new Car("BMW" , Colour.GREEN , 215 , 2017 , 10432f) ,
            new Car("BMW" , Colour.UNDEFINED , 200 , 2017 , 10000f) ,
            new Car("VW" , Colour.BLUE , 180 , 2017 , 10000f) ,
            new Car("VW" , Colour.WHITE , 220 , 2017 , 10000f) ,
            new Car("VW" , Colour.RED , 200 , 2017 , 10000f))
        .filter(c -> c.brand().equals("BMW"))
        .forEach(System.out::println);

    Stream
        .of(
            new Car("BMW" , Colour.BLUE , 200 , 2017 , 10000f) ,
            new Car("BMW" , Colour.GREEN , 215 , 2017 , 10432f) ,
            new Car("BMW" , Colour.UNDEFINED , 200 , 2017 , 10000f) ,
            new Car("VW" , Colour.BLUE , 180 , 2017 , 10000f) ,
            new Car("VW" , Colour.WHITE , 220 , 2017 , 10000f) ,
            new Car("VW" , Colour.RED , 200 , 2017 , 10000f))
        .filter(c -> c.brand().equals("VW"))
        .forEach(System.out::println);

  }

}
