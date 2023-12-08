package Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03 {

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(6);
        v.add(2);

        //predicate - takes one parameter and gives boolean result
        Predicate<Integer> integerPredicate = x -> x % 2 == 0;

        //internal implementation of lambda
        Predicate<Integer> integerPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };

        //Function - takes one element and gives result
        Function<Integer, Integer> integerIntegerFunction = x -> x * x;

        //internal implemenattion of function
        Function<Integer, Integer> integerIntegerFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        };

        //void
        Consumer<Integer> println = System.out::println;

        //internal implemnattion consumer
        Consumer<Integer> println2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        v.stream().filter(integerPredicate)
                .map(integerIntegerFunction)
                .forEach(println);
        exercise(v);
    }

    private static void exercise(List<Integer> a){

        BinaryOperator<Integer> sum = Integer::sum;
        BinaryOperator<Integer> sum2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };

        a.stream().reduce(0, sum);
    }
}
