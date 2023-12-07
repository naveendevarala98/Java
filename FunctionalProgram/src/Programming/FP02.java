package Programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02 {
    public static void main(String[] args){
        List<Integer> v = new ArrayList<>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(6);
        v.add(2);

      //  int sum = sumNumber(v);
       // System.out.println(sum);

       // reducePlay(v);

      //  exercise(v);

        //Comparator
        List<String> s = new ArrayList<>();
        s.add("spring");
        s.add("spring api");
        s.add("aws");

      //  comparator(s);

   //     List<Integer> a = doubleList(v);
     //   System.out.println(a);

        collectString(s);
    }

    private static int sum(int aggregate, int nextnumber){
        return aggregate+nextnumber;
    }
    private  static int sumNumber(List<Integer> n){
        //Stream of number -> one value
        //use reduce to get as single result
        //reduce -> initial value and method to perform
        return n.stream()
                //.reduce(0,FP02::sum); //initial value is 0 and gets adding up
               // .reduce(0,(x,y)->x+y);
                .reduce(0,Integer::sum);
    }

    private  static void reducePlay(List<Integer> n){
        int ans = n.stream().reduce(0,(x,y)->x);
        System.out.println(ans); //print 0

        int ans1 = n.stream().reduce(0,(x,y)->y);
        System.out.println(ans1); //print 6 -> last value in list

        //max
        int max = n.stream().reduce(Integer.MIN_VALUE,(x,y)->x>y?x:y);
        System.out.println(max);

        //min
        int min = n.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);
        System.out.println(min);

    }

    //exercise
    private static void exercise(List<Integer> v){

        //1.square every number in list & find sum of square
        int ans = v.stream().map(n->n*n)
                .reduce(0,(x,y)->x+y);
    //    System.out.println(ans);

        //2.cube same above
        int ans1 = v.stream().map(n->n*n*n)
                .reduce(0,(x,y)->x+y);
      //  System.out.println(ans1);

        //3.find sum of odd in list
        int ans2 = v.stream().filter(n->n%2!=0)
                .reduce(0,Integer::sum);
      //  System.out.println(ans2);

        //print distinct values
       // v.stream().distinct().forEach(System.out::println);

        //sorted values
        v.stream().sorted().forEach(System.out::println);

    }

    private static void comparator(List<String> s){
       // s.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //s.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //custom order - here based on length
        s.stream().sorted(Comparator.comparing(str->str.length())).forEach(System.out::println);


    }

    private static List<Integer> doubleList(List<Integer> v){
        List<Integer> ans = v.stream().map(n->n*n).collect(Collectors.toList());

        List<Integer> ans1 = v.stream().filter(n->n%2==0).collect(Collectors.toList());
                return ans1;
    }

    private static void collectString(List<String> v){
        List<Integer> ans = v.stream().map(a->a.length()).collect(Collectors.toList());

        System.out.println(ans);
    }
}
