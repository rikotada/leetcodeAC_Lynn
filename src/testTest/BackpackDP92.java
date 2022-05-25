package testTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BackpackDP92 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
    	 
        // write your code here
        int n = A.length;
        //dp表示对于只考虑前i个东西的情况 取或者不取分别能凑出j的数的可能性
        //dp[i][0]一定是true 因为可以都不取
        //那个dp的值是前i个的东西取或者不取的排列组合有没有可能达到j的值的意思
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 1;i <= n; i++ ){
            for(int j = 0;j <= m;j++){
                //如果背包有地方 可以选择塞进去或者不塞
                if(j >= A[i-1]){
                   dp[i][j] = dp[i-1][j-A[i-1]] || dp[i-1][j];
                }
                //没地方只能选择不塞
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
            
        }
        //最后一行（横着的）是考虑了所有物品取或者不取的情况 直接从大数往回找
        for(int k = m;k >= 0;k--){
            if(dp[n][k]){
                return k;
            }
        }
    return 0;
    }
}

