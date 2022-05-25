package testTest;

import java.util.Arrays;

public class TriangleCount382 {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        if(S == null || S.length < 3){
             return 0;
        }
        Arrays.sort(S);
        int result = 0;
        int n = S.length;
        for(int i = n - 1;i >= 2;i--){
            int left = 0;
            int right = i - 1;
            while(left + 1 <= right){
               while(left + 1 <= right && S[left] + S[right] <= S[i]){
                  left++;
               }
               result += right - left;
               right--;
            }
        }
        return result;
        
    }
 
}
