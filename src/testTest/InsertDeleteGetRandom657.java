package testTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom657 {
public class RandomizedSet {
    public Map<Integer,Integer> map;
    public List<Integer> list;
    public RandomizedSet() {
        // do intialization if necessary
        map = new HashMap<>();
        list = new ArrayList<>();
        
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if(map.containsKey(val)){
           return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if(!map.containsKey(val)){
           return false;
        }
        list.remove(map.get(val));
        map.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        Random r = new Random();
        int i = r.nextInt(map.keySet().size());
        return list.get(i);
    }
}

}
