package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII153 {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        dfs(nums,target,0,new boolean[length],0,new ArrayList<>(),result);
        return result;
    }

    public void dfs(int[] nums,int target,int index,boolean[] used,int sum,List<Integer> current,List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0;i + index < nums.length;i++){
            if(sum + nums[i + index] > target){
                continue;
            }
            if(i + index > 0 && nums[i + index] == nums[i + index-1]){
                if(!used[i + index -1]){
                   continue;
                }
            }   
            current.add(nums[i+index]);
            used[i+index] = true;
            dfs(nums,target,i+index+1,used,sum+nums[i+index],current,result);
            used[i+index] = false;
            current.remove(current.size() - 1);
        }
        return;
    }
}
