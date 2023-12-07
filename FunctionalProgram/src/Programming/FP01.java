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
      //  printEvenNumber(v);
      //  oddNumber(v);
        List<String> s = new ArrayList<>();
        s.add("spring");
        s.add("spring api");
        s.add("aws");

        //printWordInd(s);
      //  printWordSpring(s);


        //map
        //printSquareOfEven(v);
        printNoOfChar(s);

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

    //print only odd number
    private static void oddNumber(List<Integer> v){

        v.stream().filter(odd->(odd%2==1)).forEach(System.out::println);
    }

    //print word individually
    private static  void  printWordInd(List<String> s){
        s.stream().forEach(System.out::println);
        //s.forEach(System.out::println);
    }

    //prind word containing spring
    private  static void  printWordSpring(List<String> s){
        s.stream().filter(a->a.contains("spring")).forEach(System.out::println);
        s.stream().filter(a->a.length()>4).forEach(System.out::println);
    }

    //2. MAP - take that value do any operation on that print
    private  static  void printSquareOfEven(List<Integer> v){
        v.stream().filter(c->c%2==0)
                .map(number->number*number) //map
                .forEach(System.out::println);

        //print cube of odd
        v.stream().filter(c->c%2!=0)
                .map(number -> number*number*number) //it maps to that number for further validation
                .forEach(System.out::println);
    }


    private static void printNoOfChar(List<String> s){
        s.stream().map(c->c+" "+c.length())
                .forEach(System.out::println);
    }






}
