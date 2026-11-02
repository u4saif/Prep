package executor.sample.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedSample {

    static AtomicInteger sharePrice = new AtomicInteger(0);

    public   Boolean changeSharePrice(int diffAmt) throws InterruptedException {

        if(diffAmt >= 0){
            Thread newT = new Thread();
            newT.sleep(3000);
             sharePrice.set(diffAmt);
            return true;
        }
        return false;
    }

    public   int getChangeSharePrice() {
        return sharePrice.get();
    }
}

class Test{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("test started");
        SynchronizedSample ss = new SynchronizedSample();
        ss.changeSharePrice(100);


        Thread thread2 = new Thread(()-> {
            try {
            System.out.println(ss.getChangeSharePrice());
            ss.changeSharePrice(-111);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
                );
        thread2.start();
        System.out.println("---end--");
    }
}