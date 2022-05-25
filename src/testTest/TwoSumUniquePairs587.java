package testTest;

import java.util.HashMap;
import java.util.Map;

public class TwoSumUniquePairs587 {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i < n;i++){
           map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        int result = 0;
        for(Integer j:map.keySet()){
            if(target - j != j){
               if(map.containsKey(target - j) && map.get(target - j) > 0){
                  result++;
                  map.put(j,0);
               }
            }
            else{
                if(map.get(j) > 1){
                    result++;
                }
            }
        }
        return result;
    }
}