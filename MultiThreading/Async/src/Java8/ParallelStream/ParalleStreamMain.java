package Java8.ParallelStream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ParalleStreamMain {
    public static void main(String[] args)  {
        long starttime = System.currentTimeMillis();

        List<String> names = new ArrayList<>();
        names.add("bob");
        names.add("ram");
        names.add("sita");
        names.add("yyyyy");
        List<String> resultList = new ArrayList<>();

        ParalleStreamMain paralleStreamMain = new ParalleStreamMain();


        resultList=paralleStreamMain.streamData(names);


        Long elapse = System.currentTimeMillis() - starttime;
        System.out.println("time take "+elapse);
        System.out.println("data "+resultList.toString());

    }

    private List<String> streamData(List<String> names) {
        return names.parallelStream().map(this::findLength)
                .collect(Collectors.toList());
    }

    private  String findLength(String name)  {
        try {
            TimeUnit.SECONDS.sleep(1);

        }catch (Exception e){

        }
        return name.length()+" - "+name;
    }

}
