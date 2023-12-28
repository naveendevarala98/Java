package CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CFExceptio {

    private  HelloWorld hs;

    public CFExceptio(HelloWorld hs) {
        this.hs = hs;
    }

    public void CF_handle(){
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(hs::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(hs::world);


        //3.combining result
        String ans = hello
                .handle((res,e)->{ //if hello future throws any exception handle, note - even if there is not error handle calls do have check
                    if(e!=null) {
                        System.out.println("Exception is " + e.getMessage());
                        return ""; //default value, if any exceptio
                    }else {
                        return res; //original value
                    }
                })

                .thenCombine(world,(h,w)->h+w)

                .handle((res,e)->{ //if world future throws any exception handle, if no exception
                    if(e!=null) {
                        System.out.println("Exception after world is " + e.getMessage());
                        return ""; //default value, if any exceptio in world
                    }else{
                        return res;
                    }
                })
                .thenApply(String::toUpperCase)
                .join();
    }


    //exce[tioanlly - will invoke only there is exception

    public void CF_exceptionally(){
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(hs::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(hs::world);


        //3.combining result
        String ans = hello
                .exceptionally((e)->{ //if hello future throws any exception handle, only when exception

                        System.out.println("Exception is " + e.getMessage());
                        return ""; //default value, if any exceptio

                })

                .thenCombine(world,(h,w)->h+w)

                .exceptionally((e)->{ //if world future throws any exception handle,

                        System.out.println("Exception after world is " + e.getMessage());
                        return ""; //default value, if any exceptio in world

                })
                .thenApply(String::toUpperCase)
                .join();
    }


    //3.when complete - no recover, inorder to recover use exceptionally, otherwise no o/p

    public void CF_whencomplete(){
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(hs::hello);
        CompletableFuture<String> world = CompletableFuture.supplyAsync(hs::world);


        //3.combining result
        String ans = hello
                .whenComplete((res,e)->{ //if hello future throws any exception handle, only when exceptio, throws to other exception

                    System.out.println("Exception is " + e.getMessage());


                })

                .thenCombine(world,(h,w)->h+w)

                .whenComplete((res,e)->{ //if world future throws any exception handle,

                    System.out.println("Exception after world is " + e.getMessage());

                })
                .exceptionally((e)->{ // use this inorder to recover, otherwise no o/p
                    return "";
                })
                .thenApply(String::toUpperCase)
                .join();
    }
}
