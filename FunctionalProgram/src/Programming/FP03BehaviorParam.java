package Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParam {

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(6);
        v.add(2);

        Predicate<Integer> integerPredicate = x -> x % 2 == 0;

        //paramterized behaviour
    //    extracted(v, integerPredicate);
     //   extracted(v, x->x%2!=0);
       // extracted(v, x->x%3!=0);

        Function<Integer, Integer> integerIntegerFunction = x -> x * x;

        List<Integer> ans= getCollect(v, integerIntegerFunction);

        System.out.println(ans);


    }

    private static List<Integer> getCollect(List<Integer> v, Function<Integer, Integer> integerIntegerFunction) {
        return v.stream().map(integerIntegerFunction).collect(Collectors.toList());
    }

    private static void extracted(List<Integer> v, Predicate<Integer> predicate) {
        v.stream().filter(predicate)
                .forEach(System.out::println);
    }


}
