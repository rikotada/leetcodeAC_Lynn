package testTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IntersectionOfMultipleArrays2248 {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        int n = nums.length;
        int len = nums[0].length;
        for(int j = 0;j < len;j++){
            set.add(nums[0][j]);
        }

        for(int i = 1;i < n;i++){
            int length = nums[i].length;
            Set<Integer> nset = new TreeSet<>();
            for(int j = 0;j < length;j++){
               if(set.contains(nums[i][j])){
                   nset.add(nums[i][j]);
               }
            }
            set = nset;
            if(set.size() == 0){
                 return result;
            }
        }
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            result.add(it.next());
        }
        return result;
    }
}
