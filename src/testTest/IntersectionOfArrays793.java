package testTest;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays793 {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        // write your code here
        if(arrs == null || (arrs.length == 1 && arrs[0].length == 0)){
            return 0;
        }
        Set<Integer> set0 = helper(arrs,0);
        
        return set0.size();
    }

    public Set<Integer> helper(int[][] arrs,int k){
        if(k >= arrs.length){
            return null;
        }
        int n = arrs[k].length;
        if(n == 0){
            return new HashSet<>();
        }
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0;i < n;i++){
            set1.add(arrs[k][i]);
        }
        Set<Integer> set2 = helper(arrs,2*k+1);
        if(set2 != null){
            set1.retainAll(set2);
        }
        Set<Integer> set3 = helper(arrs,2*k+2);
        if(set3 != null){
            set1.retainAll(set3);
        }
       
        return set1;
        
          
    }


  
}
