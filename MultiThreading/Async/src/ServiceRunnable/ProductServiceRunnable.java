package ServiceRunnable;

import Service.ProductService;

import java.util.concurrent.TimeUnit;

public class ProductServiceRunnable implements Runnable {

    private int detail;

    private ProductService productService;

    private int val;

    //we can pass variable via constructor to use
    public ProductServiceRunnable(int detail){
        this.detail=detail;
        productService=new ProductService();
    }

    //to get the response from run
    public int getProductReturn(){
        return val;
    }



    @Override
    public void run() {
        try {

             val = productService.getProdId();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
