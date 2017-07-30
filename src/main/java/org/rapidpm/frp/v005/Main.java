package org.rapidpm.frp.v005;

import java.util.Arrays;
import java.util.List;
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

  public static Consumer<Stream<Car>> printStream = (stream) -> stream.forEach(System.out::println);

  public static void main(String[] args) {

    final Function<Predicate<Car>, Function<Stream<Car>, Stream<Car>>> filterStreamFkt =
        (filter) -> (Function<Stream<Car>, Stream<Car>>) carStream -> carStream.filter(filter);

    final Function<String, Function<Stream<Car>, Stream<Car>>> fkt = brandFilter.andThen(filterStreamFkt);

    final Stream<Car> bmwStream = fkt.apply("BMW").apply(nextCarStream());
    final Stream<Car> vwStream = fkt.apply("VW").apply(nextCarStream());

    printStream.accept(bmwStream);
    printStream.accept(vwStream);

  }
}