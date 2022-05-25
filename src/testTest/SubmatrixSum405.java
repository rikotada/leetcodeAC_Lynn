package testTest;

import java.util.HashMap;

public class SubmatrixSum405 {
    /*
     * @param matrix: an integer matrix
     * @return: the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        
        int[][] colPs = getColPrefixSum(matrix); 
        
        int n = matrix.length;
        for (int up = 0; up < n; up++) {
            for (int down = up; down < n; down++) {
                int[] colSum = getColSum(colPs, up, down); 
                int[] lr = subarraySum(colSum); 
                if (lr != null) {
                    return new int[][] {{up, lr[0]}, {down, lr[1]}};
                }
            }
        }
        
        return null;
    }
    
    // time O(n) space O(n)
    private int[] subarraySum(int[] nums) {
        // 返回 和为0的子数组的一对下标 left, right
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        HashMap<Integer, Integer> psToCnt = new HashMap<>();
        psToCnt.put(0, 0);
        
        int ps = 0;
        for (int i = 0; i < nums.length; i++) {
            ps += nums[i];
            if (psToCnt.containsKey(ps)) {
                return new int[] {psToCnt.get(ps), i};
            }
            psToCnt.put(ps, i + 1);
        }
        
        return null;
    }
    
    // time O(n^2) space O(n^2)
    private int[][] getColPrefixSum(int[][] matrix) {
        // matrix (n, m)
        // colPs  (n+1, m)
        
        //            colPs        
        //  matrix   0, 0, 0
        // 1, 5, 7   1, 5, 7
        // 3, 7,-8   4,12,-1
        // 4,-8, 9   8, 4, 8
        
        int n = matrix.length, m = matrix[0].length;
        int[][] colPs = new int[n + 1][m];
        
        for (int j = 0; j < m; j++) {
            colPs[0][j] = 0;
            for (int i = 1; i < n + 1; i++) {
                colPs[i][j] = colPs[i - 1][j] + matrix[i - 1][j];
            }
        }
        
        return colPs;
    }
    
    // time O(n) space O(n)
    private int[] getColSum(int[][] colPs, int up, int down) {
        // up=1  down=2
        //    colPs     
        // 0: 0, 0, 0
        // 1: 1, 5, 7
        // 2: 4,12,-1
        // 3: 8, 4, 8
        
        // colSum: [7, -1, 1] 
        int[] colSum = new int[colPs[0].length];
        for (int j = 0; j < colSum.length; j++) {
            colSum[j] = colPs[down + 1][j] - colPs[up][j];
        }
        return colSum;
    }
    
}
