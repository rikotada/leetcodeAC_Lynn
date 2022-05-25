package testTest;

import java.util.HashSet;

public class Deduplicate521 {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
       
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                nums[len++] = nums[i];
            }
        }
        
        return len;
    }
    
}
