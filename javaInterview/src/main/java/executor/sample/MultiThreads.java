package executor.sample;

public class MultiThreads {

//    Create Thread

    public static void main(String[] args) {
        System.out.println("MultiThreads : "+Thread.currentThread().getName());
//        Can use Runnable interface with lambda expression
//        Thread mythread = new Thread(()->{
//            System.out.println("This is :"+Thread.currentThread().getName());
//        });
//        mythread.start();

//        Using [functional interface] Runnable Interface to create Thread
    Runnable myrunnable = ()->{
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("This is runnable :"+Thread.currentThread().getName());
    };
            Thread runnableThread = new Thread(myrunnable,"runnableThread");
//            How to make demon thread
            runnableThread.setDaemon(true);
            runnableThread.start();

        System.out.println("Main thread ended");
    }



}
