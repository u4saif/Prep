package october2026;

import java.util.*;

public class LruCache extends LinkedHashMap {

    final int SIZE;
    public LruCache(int SIZE) {
        super(SIZE, 0.75f,true);
        this.SIZE = SIZE;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > SIZE;
    }

    public void add(int value){
        super.put(value,value);
    }

    public Object get(int value){
       return  super.get(value);
    }
}

class Sample{

    public static void main(String[] args) {
        LruCache cache = new LruCache(2);

        cache.add(200);
        cache.add(300);
        System.out.println( cache.get(200));
        cache.add(400);

        System.out.println(cache.get(300));

    }
}
