package Service;

import java.util.concurrent.TimeUnit;

public class ProductService {

    public int getProdId() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return 5;
    }
}
