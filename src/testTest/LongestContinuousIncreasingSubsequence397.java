package testTest;

public class LongestContinuousIncreasingSubsequence397 {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
           return 0;
        }
        if(A.length == 1){
            return 1;
        }
        int left = 0;
        int right = 0;
        int result = 1;
        while(right < A.length - 1){
            
            while(right < A.length - 1 && A[right+1] > A[right] ){
               right++;
            }
            result = Math.max(result,right - left + 1);
            right++;
            left = right;
            
        }

        left = 0;
        right = 0;

        while(right < A.length - 1){
            while(right < A.length - 1 && A[right+1] < A[right]){
               right++;
            }
            result = Math.max(result,right - left + 1);
            right++;
            left = right;
            
        }
        return result;
       
    }
}
