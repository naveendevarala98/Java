package Programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP04 {

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(6);
        v.add(2);

        //supplier, no input > return something
        Supplier<Integer> randomInteger = ()->{
            Random random = new Random();
            return random.nextInt(1000);
        };

       // System.out.println(randomInteger.get());

        //unary operator
        UnaryOperator<Integer> ans = x->3*10;
        System.out.println(ans.apply(10));

        //bipredicate -> takes two i/p and return boolean
        BiPredicate<Integer, String> bp = (x,y)->{
            return x>10 && y.length()<5;
        };

        System.out.println(bp.test(11,"rr"));

        //biFuction takes two i/p & returns - last param represent return type
        BiFunction<Integer, String, String> biFunction = (x,y)->{
            return x + " " + y;
        };

        System.out.println(biFunction.apply(5,"app"));

        //BiConsumer - two i/p - no return
        BiConsumer<String,Integer> biConsumer=(x,y)->{
            System.out.println(x);
            System.out.println(y);
        };

        biConsumer.accept("na",10);
    }
}
