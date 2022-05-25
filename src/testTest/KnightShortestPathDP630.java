package testTest;

public class KnightShortestPathDP630 {
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        int a = grid.length;
        int b = grid[0].length;
        if(grid[0][0] || grid[a-1][b-1] ){
              return -1;
        }
        int[][] dp = new int[a][b];
        int[] x = {1,-1,2,-2};
        int[] y = {2,2,1,1};
        dp[0][0] = 1;
        for(int j = 0; j < b;j++){
            for(int i = 0;i < a;i++){
                for(int k = 0;k<4;k++){     
                    int e =   i + x[k];
                    int f =   j + y[k];         
                    if(e < a && 
                       e >=0 && 
                       f >= 0 && 
                       f < b && 
                       !grid[e][f] &&
                       dp[i][j] > 0 &&
                       (dp[e][f] == 0 ||
                       dp[e][f] > dp[i][j])){     
                           dp[e][f] = 1 + dp[i][j];                      
                    }
                }
            }
        } 
        return (dp[a-1][b-1] > 0) ? dp[a-1][b-1]-1 : -1;
    }
    
    
    public int shortestPath3(boolean[][] grid) {
        // write your code here
        int a = grid.length;
        int b = grid[0].length;
        if(grid[0][0] || grid[a-1][b-1] ){
              return -1;
        }
        int[][] dp = new int[a][3];
        int[] x = {-1,1,-2,2};
        int[] y = {-2,-2,-1,-1};
        dp[0][0] = 0;
        for(int p = 1; p < a;p++){
           dp[p][0] = Integer.MAX_VALUE;
        }
        for(int j = 1; j < b;j++){
            for(int i = 0;i < a;i++){
                dp[i][j%3]  = Integer.MAX_VALUE;
                for(int k = 0;k<4;k++){                      
                    int e =   i + x[k];
                    int f =   j + y[k];
                    if(e >= a || e < 0 || f < 0 || f >= b){
                         continue;
                    }    
                    if(!grid[e][f] &&                 
                       dp[e][f%3] != Integer.MAX_VALUE &&
                       dp[e][f%3] < dp[i][j%3]){  
                           dp[i][j%3] = 1 + dp[e][f%3];
                           int u = j%3;                                     
                    }
                }
            }
        } 
        return (dp[a-1][(b-1)%3] == Integer.MAX_VALUE) ? -1 : dp[a-1][(b-1)%3];
    }
}
