package executor.sample;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Math.random;

public class Demo1 {

    public static void main(String[] args) {
        System.out.println("Demo 1 started");
        DemoThread();
        System.out.println("Demo 1 finished");
    }

    public static void DemoThread(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Double> f1 =  executorService.submit(()-> {
            try {
                Thread.currentThread().sleep(3000);
               // Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("execute using consumer"+ Thread.currentThread().getName());
            return Math.random();
        });
        try {
            if(f1.isDone()){
                f1.get();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
