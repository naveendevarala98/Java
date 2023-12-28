package ExecutorJava5;

import Service.ProductService;
import Service.ReviewService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorThread {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //this next version of the thread/runnable
        /****
         * java - 5
         * 1. Thread need not be run manually
         * 2. uses executor service - which has thread pool, working queue, completion queue
         * 3. uses future which has the result of that thread
         * 4. task parallelism - executor service - each task runs is async
         */

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        ProductService productService=new ProductService();
        ReviewService reviewService=new ReviewService();

        long starttime = System.currentTimeMillis();


        Future<Integer> productFuture = executorService.submit(()->productService.getProdId());
        Future<String> reviewFuture = executorService.submit(()-> reviewService.getReview());

        int pval = productFuture.get();
        String rval = reviewFuture.get();

        Long elapse = System.currentTimeMillis() - starttime;
        System.out.println("time take "+elapse);
        System.out.println("ps val "+pval+" review "+ rval);

        executorService.shutdown();
    }
}
