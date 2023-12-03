package Programming;

import java.util.ArrayList;
import java.util.List;

public class FP01 {
    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(45);
        v.add(6);

      //  printNumberStructure(v);
        printEvenNumber(v);
    }

    private static void print(int n){
        System.out.println(n);
    }

    private static void printNumberStructure(List<Integer> v){

        //1.method
        v.stream().
                forEach(FP01::print); //method reference

        //2.method - little simple
        v.stream().forEach(System.out::println);

//        for(int a:v){
//            System.out.println(a);
//        }
    }


    private static boolean isEven(int n){
        return n%2==0;
    }

    private  static void printEvenNumber(List<Integer> v){
//1.method
//        v.stream()
//                .filter(FP01Structured::isEven) //method reference - only true go next line
//                .forEach(System.out::println);

        //2.methdod - lambda expression
        v.stream()
                .filter(number->number%2==0) // lambda expression - instead of method in simple method
                .forEach(System.out::println); //method reference

//Traditional way
        //        for(int number:v){
//            if(number%2==0){
//                System.out.println(number);
//            }
//        }
    }
}
