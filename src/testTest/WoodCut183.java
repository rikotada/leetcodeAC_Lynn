package testTest;

import java.util.ArrayList;
import java.util.Iterator;

public class WoodCut183 {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int n = L.length;
        long sum = 0;
        for(int i = 0;i < n;i++){
            sum = sum + L[i];
        }
        if(sum < k){
           return 0;
        }
        int max = (int)(sum / k);
        int start = 1,end = max;
        while(start + 1 < end){
             int mid = start + (end - start) / 2;
             if(numberOfPieces(L,mid) >= k){
                start = mid;
             }
             else{
                 end = mid;
             }
        }
        if(numberOfPieces(L,end) >= k){
            return end;
        }
        return start;
       
    }
    
    public long numberOfPieces(int[] nums,long length){
         int n = nums.length;
         long result = 0;
         for(int i = 0;i < n;i++){
            result = result + nums[i] / length;
         }
         return result;
    }
    
}