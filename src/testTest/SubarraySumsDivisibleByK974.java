package testTest;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK974 {
    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        arr[0] = nums[0];
        for(int i = 1;i < len;i++){
           arr[i] = arr[i - 1] + nums[i];
        }
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < len;i++){
           int key = arr[i] % k;
           if(key < 0){
              key = key + k;
           }
           else if(key == 0){
              result++;
            }
           if(!map.keySet().contains(key)){
               map.put(key,1);
           }
           else{
               map.put(key,map.get(key) + 1);
           }
        }
        for(Integer left:map.keySet()){
            int time = map.get(left);
            result +=  time * (time - 1) / 2;
        }
        return result;
    }
}