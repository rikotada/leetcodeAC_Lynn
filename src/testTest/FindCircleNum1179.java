package testTest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindCircleNum1179 {
	public int findCircleNum(int[][] M) {
	int result = 0;
	      
	if(M == null){
	    return result;
	 }
	 int length = M.length;
	 Set<Integer> set = new HashSet<>();
	 Queue<Integer> q = new LinkedList<>();
	 q.offer(0);
	 while(!q.isEmpty()){
	       Integer studentN = q.poll();
	       if(studentN <0){
	            break;
	       }
	       if(!set.contains(studentN)){
              for(int i = 0;i < length;i++){
	            if(M[studentN][i] == 1 && studentN != i && !set.contains(i)){
	             q.offer(i);
                 }
	          }
	        }
           set.add(studentN);
	       if(q.isEmpty()){
             result++;
             q.offer(helper(set,length));
	       }          
	   }
	  return result;
  }
	    
	    private int helper(Set<Integer> set,int length){
	         int i = 0;
	         if(set.size() == length){
	             return -1;
	         }
	         for(i = 0;i<length;i++){
	             if(!set.contains(i)){
	                 return i;
	             }
	         }
	         return -1;
	    }
}
