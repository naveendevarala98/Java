package ForkJoinJava7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ForJoin {

    /**
     * 1. Fork join framework - data based parallelism
     * 2. This means each task divided into subtasks and share among the thread.
     *refer udemy pragmatic code school for code
     */

    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();

        List<String> names = new ArrayList<>();
        names.add("bob");
        names.add("ram");
        names.add("sita");
        names.add("yyyyy");
        List<String> resultList = new ArrayList<>();

        names.forEach((name)->{
            String newVal = null;
            try {
                newVal = findLength(name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            resultList.add(newVal);
        });


        Long elapse = System.currentTimeMillis() - starttime;
        System.out.println("time take "+elapse);
        System.out.println("data "+resultList.toString());

    }

    private static String findLength(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return name.length()+" - "+name;
    }
}
