import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(10);
        for(int i=1; i<=100; i++){
            int num=i;
            executor.submit(() -> {
                try{
                    Thread.sleep(100);
                    System.out.println(num);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
            executor.awaitTermination(100, TimeUnit.MILLISECONDS);
        }
        executor.shutdown();
    }
    }

