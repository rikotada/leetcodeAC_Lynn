package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factorization652{
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        // write your code here
	   if(n <= 1){
            return result;
	   }
	   helper(n,new ArrayList<>(),2);
	   int[] arr = new int[1000];
	    Arrays.fill(arr,Integer.MAX_VALUE);
	   return result;


    }

    public void helper(int n,List<Integer> current,int lastDivisor){
         if(n == 1){
		    if(current.size() == 1){
                   return;
		    }
             result.add(new ArrayList<>(current));
		   return;
	    }
	    for(int m = lastDivisor;m <=(int)Math.sqrt(n);m++){
             int num = n;
		   if(num % m == 0){
			  num = num / m;
                 current.add(m);
			  helper(num,current,m);
			  current.remove(current.size() - 1);
		   }		   
	    }
	    current.add(n);
	    helper(1,current,n);
	    current.remove(current.size() - 1);
	    return;
    }
}
