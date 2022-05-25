package testTest;

public class CopyBooks437 {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages == null||pages.length == 0 ){
              return 0;
        }
        int n = pages.length;
        int[][] dp = new int[n+1][k+1];
        for(int i = 1; i<=n;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        int[] prefixSum = new int[n+1];
        for(int j = 1;j <= n;j++){
            prefixSum[j] = prefixSum[j-1] + pages[j-1];
        }
        for(int p = 1; p<=n;p++){
           for(int m = 1; m <= k;m++){
               dp[p][m] = Integer.MAX_VALUE;
               for(int q = 0;q <=p-1;q++){
                  dp[p][m] = Math.min(dp[p][m],Math.max(dp[q][m-1],prefixSum[p]-prefixSum[q])); 
               }
           }
        }
        return dp[n][k];
    }
}
