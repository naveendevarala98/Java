package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CFmain {

    private  HelloWorld hs;

    public CFmain(HelloWorld hs) {
        this.hs = hs;
    }



    public static void main(String[] args) {

        HelloWorld hs = new HelloWorld();

        //1.BASIC TO WRITE CF
//        CompletableFuture.supplyAsync(()->hs.helloWorld())
//                .thenApply(String::toUpperCase)
//                .thenAccept((result)->{
//                    System.out.println("result "+result);
//                }).join();

        //2.make asunc call and the combine

        long starttime = System.currentTimeMillis();


        //2.makes async call to both the service
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(hs::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(hs::world);
        CompletableFuture<String> hi = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);

            }catch (Exception e){

            }
            return "Hi completableFurure";
        });
        CompletableFuture<String> hi1 = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(1);

            }catch (Exception e){

            }
            return "Hi completableFurure";
        });

        //3.combining result
        String ans = hello
                .thenCombine(world,(h,w)->h+w)
                .thenCombine(hi,(previous,current)->previous+current) //for combining three result
                .thenCombine(hi1,(previous,current)->previous+current) // for combing 4 result and continue
                .thenApply(String::toUpperCase)
                .join();

        Long elapse = System.currentTimeMillis() - starttime;
        System.out.println("time take "+elapse);
        System.out.println(ans);

        String combineAns = CompletableFuture.supplyAsync(()->hs.hello())
                        .thenCompose((previous)->hs.combine(previous))
                                .join();
        System.out.println("combine "+combineAns);

        System.out.println("main exited");
    }

    public CompletableFuture<String> helooword(){

        //To get the ans directly use join
     //   String ans = CompletableFuture.supplyAsync(hs::helloWorld)
        //   .thenApply(String::toUpperCase).join();

        return CompletableFuture.supplyAsync(hs::helloWorld)
                .thenApply(String::toUpperCase);
    }

    //async call to two service and then combine the result
    public  void helloworld_combine(){
        //makes async call to both the service
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(hs::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(hs::world);

        //combining result
        String ans = hello.thenCombine(world,(h,w)->h+w).join();
        System.out.println(ans);
    }
}
