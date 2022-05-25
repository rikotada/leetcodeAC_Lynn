package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//基于 BFS 的方法
//在 BFS 那节课的讲解中，我们很少提到用 BFS 来解决找所有的方案的问题。事实上 BFS 也是可以用来做这件事情的。
//用 BFS 来解决该问题时，层级关系如下：

//第一层: []
//第二层: [1] [2] [3]
//第三层: [1, 2] [1, 3], [2, 3]
//第四层: [1, 2, 3]
public class SubsetBFS {

	public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        Arrays.sort(nums);
        Queue<List<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<Integer>());
        while(!q.isEmpty()){
            List<Integer> subset = q.poll();
           
            result.add(subset);
            for(int i = 0;i < nums.length; i++){
                if(subset.size() == 0 || 
                   subset.get(subset.size() - 1) < nums[i]){
                    List<Integer> subsetNew = new ArrayList<>(subset);
                    subsetNew.add(nums[i]);
                    q.offer(subsetNew);
                }
                
            }
        }
        return result;
    } 
}
