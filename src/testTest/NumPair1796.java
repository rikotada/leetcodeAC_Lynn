package testTest;

import java.util.HashSet;
import java.util.Set;

public class NumPair1796 {
   public int KDifferent(int nums[], int target) {
	   if(target == 0) {
		   return nums.length;
	   }
	   Integer count = 0;
	   Set<Integer> set = new HashSet<>();
	   for(int n:nums) {
		   set.add(n);
		   if(set.contains(n+target)) {
			  count++; 
		   }
		   if(set.contains(n-target)) {
			   count++;
		   }
	   }
	   return count;
   }
}
