package testTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class FirstUniqueNumberInDataStream685 {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    class Tool{
        boolean arrived;
        int position;
        public Tool(boolean arrived,int position){
            this.arrived = arrived;
            this.position = position;
        }
    }
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        if(nums == null || nums.length == 0){
             return -1;
        }
        Map<Integer,Tool> map = new HashMap<>();
        int n = nums.length;
        boolean find = false;
        for(int i = 0;i < n;i++){
            if(nums[i] == number){
               find = true;
            }
            if(map.containsKey(nums[i])){
               Tool t = new Tool(false,i);
               map.put(nums[i],t);
            }
            else{
               map.put(nums[i],new Tool(true,i));
            }
            if(nums[i] == number){
              break;
            }
        }
        if(!find){
           return -1;
        }
        int min = Integer.MAX_VALUE;
        for(Integer m:map.keySet()){
           if(map.get(m).arrived && map.get(m).position < min){
              min = map.get(m).position;
           }
        }
        return nums[min];
    }
}
