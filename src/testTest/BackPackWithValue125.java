package testTest;

public class BackPackWithValue125 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;
        //dp[i][j]表示前i个东西里选凑出来j的值的时候的最大value
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i <= n;i++){
            for(int j = 0; j <= m; j++){
               if(j >= A[i - 1]){
            	   //取的value和不取的value相比较
                  dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-A[i-1]] + V[i - 1]);
               }
               else{
                   dp[i][j] = dp[i-1][j];
               }
            }
        }
        return dp[n][m];
    }
}
