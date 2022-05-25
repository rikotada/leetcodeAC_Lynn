package testTest;

import java.util.ArrayList;
import java.util.List;

public class SubarraySum138 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
             return result;
        }
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int i = 1;i < n+1;i++){
           prefix[i] = prefix[i-1]+nums[i-1];
        }
        for(int m = 0;m <n;m++){
           for(int j = m+1;j<n+1;j++){
             if(nums[m] == 0 ||prefix[j] == prefix[m]){
                 result.add(m);
                 result.add(j-1);
                 return result;
             }
           }
        }
        return result;
    }
}
