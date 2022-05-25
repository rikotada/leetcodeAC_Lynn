package testTest;

public class BackpackIII440 {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
	   if(A == null || A.length == 0 || m == 0){
            return 0;
	   }
	   int len = A.length;
	   int[] dp = new int[m + 1];
	   int result = 0;
	   for(int i = 1;i <= m;i++){
            int sum = 0;
		  for(int k = 0;k < len;k++){
                if(i - A[k] < 0){
                   continue;
			 }
			 sum = Math.max(sum, dp[i - A[k]] + V[k]);
		  }
		  dp[i] = sum;
		  result = Math.max(result,dp[i]);
	   } 
	   return result;
    }
}
