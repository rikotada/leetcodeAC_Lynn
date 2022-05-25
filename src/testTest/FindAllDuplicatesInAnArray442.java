package testTest;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for(int i = 0;i < len;i++){
            int s = nums[i];
            while(s != nums[s - 1]){
                int temp = nums[s - 1];
                nums[s - 1] = nums[i];
                nums[i] = temp;
                s = nums[i];
            }
        }
        for(int i = 0;i < len;i++){
          if(nums[i] != i + 1){
             result.add(nums[i]);
          }
        }
        return result;
    }
}
