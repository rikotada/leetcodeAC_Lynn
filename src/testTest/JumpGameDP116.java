package testTest;

public class JumpGameDP116 {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        if(A == null || A.length <= 1){
             return true;
        }
        int length = A.length;
        int[] dp = new int[length];
        dp[0] = 1;
        //dp[n]表示能否从头跳到这个点
        for(int i = 1;i<length;i++){
           int j = 0;
           for(j = i - 1;j >=0;j--){
              if(dp[j] == 1 && A[j] +j >= i){
                   dp[i] = 1;
                   break;
              }
           }
           if(j < 0){
               return false;
           }
        }
        return true;
    }
}
