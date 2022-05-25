package testTest;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache134 {
    /*
    * @param capacity: An integer
    */
    Map<Integer,Integer> map;
    Integer cap;
 
    public LRUCache134(int capacity) {
        // do intialization if necessary
        map = new LinkedHashMap<>();
        cap = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        int result = -1;
        if(map.containsKey(key)){
           result = map.get(key);
           map.remove(key);
           map.put(key, result);
        }
        return result;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(!map.containsKey(key)){
           if(map.size() >= cap){
                int oldKey = 0;
                for(Integer i:map.keySet()){
                    oldKey = i;
                    break;
                }
                map.remove(oldKey);
                map.put(key, value);
            }
            else{
                map.put(key, value);
            }
        }
        else{
           map.remove(key);
           map.put(key, value);
        }

    }
}