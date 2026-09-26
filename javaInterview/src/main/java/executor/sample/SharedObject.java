package executor.sample;

public class SharedObject {

    public  volatile   boolean completed;

    public  void setCompleted(boolean value){
        completed = value;
    }

    public boolean getCompleted(){return this.completed;}
}
