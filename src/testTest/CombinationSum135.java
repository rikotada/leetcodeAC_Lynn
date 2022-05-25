package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum135 {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
           result.add(new ArrayList<Integer>());
           return result;
        }
        Arrays.sort(candidates);
        dfs(candidates,target,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    public void dfs(int[] candidates,int target,int pointer,List<Integer> current,List<List<Integer>> result){
        if(target == 0){
           result.add(new ArrayList<>(current));
           return;
        }
        for(int i = pointer;i < candidates.length;i++){
           if(target - candidates[i] < 0){
              continue;
           }
           if(i > pointer && candidates[i] == candidates[pointer]){
              continue;
           }
           current.add(candidates[i]);
           dfs(candidates,target - candidates[i],i,current,result);
           current.remove(current.size() - 1);
        }
        return;
    }

}