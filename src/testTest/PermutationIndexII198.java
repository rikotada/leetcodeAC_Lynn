package testTest;

import java.util.HashMap;
import java.util.Map;

public class PermutationIndexII198 {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndexII(int[] A) {
        // write your code here
	   if(A == null || A.length == 0){
           return 0L;
	   }
        int n = A.length;
	   long result = 0L;
	   for(int i = n - 1;i >= 0;i--){
             result += result(A, i);
	   }
	   return result + 1;
    }

    public long factorial(int n){
	  if(n == 0){
          return 0L;
	  }
       long result = 1L;
	  for(int i = n; i > 0;i--){
          result *= i;
	  }
	  return result;
    }

    public long result(int[] A,int index){
	    if(index == A.length - 1){
            return 0L;
	    }
	    
        Map<Integer,Integer> duplicate = new HashMap<>();
	   int lessThan = 0;
	   for(int i = A.length - 1;i >= index;i--){
           if(A[i] < A[index]){
               lessThan++;
		 }
		 if(!duplicate.keySet().contains(A[i])){
              duplicate.put(A[i],1);
		 }
		 else{
              duplicate.put(A[i],duplicate.get(A[i]) + 1);
		 }
	   }
	   long dividor = 1L;
	   for(Integer m:duplicate.keySet()){
           if(duplicate.get(m) > 1){
              dividor = dividor * factorial(duplicate.get(m));
		 }
	   }
	   long result = lessThan * factorial(A.length - index - 1) / dividor;
	   return result;
    }


	   

}
