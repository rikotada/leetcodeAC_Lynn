package testTest;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes602 {
    /**
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        if(envelopes == null || envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator(){
            public int compare(Object o1,Object o2){
               int[] n1 = (int[])o1;
               int[] n2 = (int[])o2;
               if(n1[0] != n2[0]){
                 return n1[0] - n2[0];
               }
               return n2[1] - n1[1];
            }
        });
        
        int result = 0;
       
        int[] tail = new int[envelopes.length];
        Arrays.fill(tail, Integer.MAX_VALUE);
        for(int i = 0;i < envelopes.length;i++){
            //这块要注意！第一个不用比直接填写 第二个要比所以要改循环条件
            int left = 0,right = i;
            while(left < right){
               int mid = (left + right) / 2;
               if(tail[mid] < envelopes[i][1]){
                    left = mid + 1;
               }
               else{
                   right = mid;
               }
            }
            tail[right] = envelopes[i][1];
            result = Math.max(result,right);
        }
        return result + 1;
        
    }
}
