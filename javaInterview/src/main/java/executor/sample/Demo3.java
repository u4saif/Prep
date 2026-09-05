package executor.sample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo3 {

    public static void main(String[] args) {
        System.out.println("Demo three---");
        DemoThree();
        System.out.println("demo three end");
    }

    private static  void DemoThree(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Double> f1 =  CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return Math.random();
        }).thenApply((data)-> data*100);

        CompletableFuture<Double> f2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
          return Math.random()*10;
        });
        CompletableFuture<Double> f3 = f1.thenCombine(f2,(a,b)->a*b);

        try {
            System.out.println(f3.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
