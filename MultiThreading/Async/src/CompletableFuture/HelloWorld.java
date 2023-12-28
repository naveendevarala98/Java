package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class HelloWorld {

    public String helloWorld(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }
        System.out.println("inside helloworld");
        return "helloworld";
    }

    public String hello(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }
        System.out.println("inside hello");
        return "hello";
    }

    public String world(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }
        System.out.println("inside world");
        return "world";
    }

    public CompletableFuture<String> combine(String s1){
        return CompletableFuture.supplyAsync(()->{
          try{
              TimeUnit.SECONDS.sleep(1);
          }catch (Exception e){

          }
          return s1+"world";
        });
    }
}
