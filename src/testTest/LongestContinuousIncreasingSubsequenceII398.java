package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestContinuousIncreasingSubsequenceII398 {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    int length = 0;
    Set<Integer> set = new HashSet<>();
    List<Integer> longList = new ArrayList<>();
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0){
              return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] xDelta = {1,-1,0,0};
        int[] yDelta = {0,0,1,-1};
        int maxLength = 0;
        List<List<Integer>> points = new ArrayList<>(); 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                points.add(Arrays.asList(i, j, matrix[i][j]));
            }
        }

        points.sort((p1, p2) -> Integer.compare(p1.get(2), p2.get(2)));
        int[][] dp = new int[rows][cols];
        for(List<Integer> values:points){
             int x = values.get(0);
             int y = values.get(1);
             dp[x][y] = (dp[x][y] == 0) ? 1 : dp[x][y];
             int v = values.get(2);
             for(int k = 0;k < 4;k++){
                int newX = x + xDelta[k];
                int newY = y + yDelta[k];
                if(newX < 0 || newX >= rows || newY < 0 || newY >= cols){
                    continue;
                }
                if(matrix[newX][newY] <= v){
                   continue;
                }
                dp[newX][newY] = Math.max(dp[newX][newY],dp[x][y] + 1);
             }
        }
        for(int c = 0;c < rows;c++){
           for(int d = 0;d < cols;d++){
              maxLength = Math.max(maxLength,dp[c][d]);
           }
        }        
        return maxLength;
    }

}
