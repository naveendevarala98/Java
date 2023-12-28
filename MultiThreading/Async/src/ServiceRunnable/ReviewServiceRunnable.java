package ServiceRunnable;

import Service.ProductService;
import Service.ReviewService;

import java.util.concurrent.TimeUnit;

public class ReviewServiceRunnable implements Runnable {

    private String val;

    private int detail;

    private ReviewService reviewService;

    //we can pass variable via constructor to use
    public ReviewServiceRunnable(int detail){
        this.detail=detail;
        reviewService=new ReviewService();
    }

    //to get the response from run
    public String getProductReturn(){
        return val;
    }



    @Override
    public void run() {
        try {

            val = reviewService.getReview();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
