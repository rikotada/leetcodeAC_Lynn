package testTest;

public class RangeSumQuery2DImmutable665 {

    int[][] val = null;
    public RangeSumQuery2DImmutable665(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        val = new int[m][n];
        helper(val,matrix);
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int minus1 = 0, minus2 = 0,minus3 = 0;
        if(row1 > 0){
           minus1 = val[row1 - 1][col2];
        }
        if(col1 > 0){
           minus2 = val[row2][col1 - 1];
        }
        if(row1 > 0 && col1 > 0){
           minus3 = val[row1 - 1][col1 - 1];
        }
         return val[row2][col2] - minus1 - (minus2 - minus3);
    }

    public void helper(int[][] val,int[][] matrix){
         int m = val.length;
         int n= val[0].length;
         for(int i = 0; i < m;i++){
            for(int j = 0;j < n;j++){
              int up = 0,left = 0,corner = 0;
              if(i != 0){
                 up = val[i - 1][j];
              }
              if(j != 0){
                 left = val[i][j - 1];
              }
              if(i != 0 && j != 0){
                 corner = val[i - 1][j - 1];
              }
              val[i][j] = matrix[i][j] + left + up - corner;
            //   System.out.println("i: "+i+" j: "+j+" val: "+val[i][j]);
            }
         }
         return;
    }
}
