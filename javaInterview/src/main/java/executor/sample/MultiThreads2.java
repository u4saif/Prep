package executor.sample;

public class MultiThreads2 {

//  Visibility problem with Volatile
public static  SharedObject sharedObject = new SharedObject();

    public static void main(String[] args) {

        System.out.println("MultiThreads2 : "+Thread.currentThread().getName());

        Runnable newRunnableThread = ()->{
            System.out.println("thread 1 started: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println(sharedObject.getCompleted());
                sharedObject.setCompleted(true);
//                System.out.println("flag updated----"+sharedObject.getCompleted());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable newRunnableThread2 = ()->{
            System.out.println("thread 2 started: " + Thread.currentThread().getName());
            while (!sharedObject.getCompleted()){
            }
            System.out.println("T2 thread ended");
        };

        Thread t1 = new Thread(newRunnableThread,"T1");
        Thread t2 = new Thread(newRunnableThread2,"T2");
        t1.start();
        t2.start();
        System.out.println("Main thread ended");
    }



}
