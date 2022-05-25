package testTest;

public class Search2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int result = 0;
        int leftStart = binaryLeft(matrix,target);
        int rightStart = binaryRight(matrix,target);
        for(int i = rightStart;i <= leftStart;i++){
            if(binaryRow(matrix,target,i)){
                 result++;
            }
        }
        return result;


    }

    public int binaryLeft(int[][] matrix,int target){
        int left = 0;
        int right = matrix.length - 1;
        if(matrix[right][0] <= target){
           return right;
        }
        while(left + 1 < right){
            int midValue = matrix[(left + right) / 2][0];
            if(midValue > target){
                 right = (left + right) / 2;
            }
            else{
                left = (left + right) / 2;
            }
        }
        if(matrix[right][0] == target){
           return right;
        }
        return left;
    }

    public int binaryRight(int[][] matrix,int target){        
        int left = 0;
        int right = matrix.length - 1;
        int n = matrix[0].length - 1;
        if(matrix[right][n] <= target){
            return right;
        }
        else if(matrix[left][n] >= target){
           return 0;
        }
        while(left + 1 < right){
            int midValue = matrix[(left + right) / 2][n];
            if(midValue >= target){
                 right = (left + right) / 2;
            }
            else{
                left = (left + right) / 2;
            }
        }
        if(matrix[left][0] == target){
           return left;
        }
        return right;
    }

    public boolean binaryRow(int[][] matrix,int target,int row){
        int left = 0;
        int right = matrix[0].length - 1;
        
        while(left + 1 < right){
            int midValue = matrix[row][(left + right) / 2];
            if(midValue > target){
                 right = (left + right) / 2;
            }
            else{
                left = (left + right) / 2;
            }
        }
        return (matrix[row][left] == target || matrix[row][right] == target);
    }
}
