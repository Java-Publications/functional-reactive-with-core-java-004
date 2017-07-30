package org.rapidpm.frp.v004;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.rapidpm.frp.model.Quint;

/**
 *
 */
public class Main {
  //random erzeugt und in ein Vaadin Grid / Chart
  //Speed mph or kmh
  //price amount and currency

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

  //persistence storage
  public static List<Car> cars = Arrays.asList(
      new Car("BMW" , Colour.BLUE , 200 , 2017 , 10000f) ,
      new Car("BMW" , Colour.GREEN , 215 , 2017 , 10432f) ,
      new Car("BMW" , Colour.UNDEFINED , 200 , 2017 , 10000f) ,
      new Car("VW" , Colour.BLUE , 180 , 2017 , 10000f) ,
      new Car("VW" , Colour.WHITE , 220 , 2017 , 10000f) ,
      new Car("VW" , Colour.RED , 200 , 2017 , 10000f)
  );

  //query -> result from persistence storage
  public static Stream<Car> nextCarStream() {
    return cars.stream();
  }

  public static Function<String, Predicate<Car>> brandFilter = (brand) -> (car) -> car.brand().equals(brand);

  public static BiFunction<Stream<Car>, String, Stream<Car>> filteredStream =
      (stream , brand) -> stream.filter(brandFilter.apply(brand));

  public static Consumer<Stream<Car>> printStream = (stream) -> stream.forEach(System.out::println);

  public static void main(String[] args) {

    printStream.accept(filteredStream.apply(nextCarStream() , "BMW"));
    printStream.accept(filteredStream.apply(nextCarStream() , "VW"));

  }
}