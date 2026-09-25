package dev.saif;

import java.sql.Connection;

//Double check - locking singleton
public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instanse;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){

        if(instanse == null){
            synchronized (ThreadSafeSingleton.class) {
                if(instanse == null) {
                    instanse = new ThreadSafeSingleton();
                }
            }
        }

        return instanse;
    }
}

//Bill puge

//public class ThreadSafeSingleton{
//    private ThreadSafeSingleton(){}
//
//    private static class Holder{
//        private static final ThreadSafeSingleton INSTANSE = new ThreadSafeSingleton();
//    }
//
//    public static ThreadSafeSingleton getInstanse(){
//        return Holder.INSTANSE;
//    }
//
//
//}


//-----------------------------------
class DatabaseConnectionManager {
    private static volatile DatabaseConnectionManager instance;
    private final Connection connection;

    private DatabaseConnectionManager() {
        this.connection = createExpensiveConnection(); // heavy setup, run only once
    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private Connection createExpensiveConnection() {
        System.out.println("Opening DB connection...");
        // actual JDBC connection setup would go here
        return null; // placeholder
    }
}
