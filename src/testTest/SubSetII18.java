package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII18 {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        
        if(nums == null || nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,new ArrayList<>(),used);
        return result;
    }

    public void dfs(int[] nums,int i,List<Integer> current,boolean[] used){
         if(nums.length == i){
             result.add(new ArrayList<>(current));
             return;
         }
         dfs(nums,i + 1,current,used);
         if(i> 0 && nums[i] == nums[i- 1] && !used[i-1]){
             return;
         }
         current.add(nums[i]);
         used[i] = true;
         dfs(nums,i+ 1,current,used);
         current.remove(current.size() - 1);
         used[i] = false;
         return;
    }
}
