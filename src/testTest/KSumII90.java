package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSumII90 {
    /**
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(A == null || A.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(A);
        dfs(A,0,target,k,new ArrayList<Integer>(),result);
        return result;
    }
    public void dfs(int[] nums,int index,int target,int k,List<Integer> current,List<List<Integer>> result){
        if(target == 0 && current.size() == k){
           result.add(new ArrayList<>(current));
           return;
        }
        for(int i = index;i < nums.length;i++){
           if(target-nums[i] < 0 || current.size() >= k){
             continue;
           }
           current.add(nums[i]);
           dfs(nums,i+1,target - nums[i],k,current,result);
           current.remove(current.size()-1);
        }
        return;
    }
}
