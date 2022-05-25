package testTest;

public class GlobalAndLocalInversions1037 {
    /**
     * @param A: an array
     * @return: is the number of global inversions is equal to the number of local inversions
     */
    public boolean isIdealPermutation(int[] A) {
        // Write your code here
        if(A == null || A.length <= 1){
            return true;
        }
        int len = A.length;;
        int[] min = new int[len];
        min[len - 1] = A[len - 1];
        for(int i = len - 2;i >= 0;i--){
            min[i] = Math.min(min[i + 1],A[i]);
        }
        for(int j = 0;j < len;j++){
            if(j + 2 < len && min[j + 2] < A[j]){
               return false;
            }
        }
        return true;
    }
}
