package testTest;

public class BestTimeToBuyAndSellStockIII151 {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2){
            return 0;
        }
        int n = prices.length;
        //dp[i][j] = at maximum i-th trade the max profit can get at j-th day
        //cause the problem only allows twice trade the i has maximum value 2
        //one has two options 
        //1.do nothing, then the profit is dp[i][j-1]
        //2.sell the stock, then the profit is prices[j] - prices[m] + dp[i-1][m], 0 < m < j-1;
        //to save time complexity, set maxDiff = max difference between max profit and price before j-th day      
        int[][] dp = new int[3][n];
        for(int i = 1;i < 3;i++){
            int maxDiff = Integer.MIN_VALUE;
            for(int j = 1;j < n;j++){
                maxDiff = Math.max(maxDiff,dp[i-1][j-1] - prices[j-1]);
                dp[i][j] = Math.max(dp[i][j-1],prices[j] + maxDiff);                
            }
        }
        return dp[2][n-1];
    }

    
}