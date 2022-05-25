package testTest;

import java.util.HashMap;
import java.util.Map;

public class TwoSum607 {
    /**
     * @param number: An integer
     * @return: nothing
     */
     Map<Integer,Integer> nums;

    public TwoSum607(){
        nums = new HashMap<>();
     }
    public void add(int number) {
        if(nums.containsKey(number)){
           nums.replace(number,nums.get(number)+1);
        }
        else{
           nums.put(number,1);
        }     
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        for(Integer n:nums.keySet()){
           if(nums.get(n) > 1){
              if(nums.containsKey(value - n)){
                return true;
              }
           }
           else{
               if((value-n)!= n && nums.containsKey(value - n)){
                 return true;
               }
           }
        }
        return false;
    }
}
