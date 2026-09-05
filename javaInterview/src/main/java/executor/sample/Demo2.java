package executor.sample;

import java.util.concurrent.*;

public class Demo2 {

    public static void main(String[] args) {
        System.out.println("demo started");
        DemoSample();
        System.out.println("Thread stoped");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static  void DemoSample(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Void> f1 =  CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return Math.random();
        }).thenAccept((data)-> System.out.println(data*100));
    }
}
