
package com.javadsa.InstanceInitializer;

import java.util.Collections;
import java.util.Queue;
import java.util.stream.Collectors;

//Example of Static Initializer vs member Initializer
public class InstanceInitializer {
    static int count;
    int memberCount;
    {
        System.out.println("Member Initializer called");
        memberCount++;
        count++;

    }
    InstanceInitializer(){
        System.out.println("Constructor called");
    }

    static {
        System.out.println("Static Initializer called");
        count = 1;
    }


    void showBothCount(){
        System.out.println("Count : "+count + " Member count "+memberCount);
    }
}

class MyExample{
    public static void main(String[] args) {
        System.out.println("My class Main called");
        InstanceInitializer init = new InstanceInitializer();
        init.showBothCount();

    }
}