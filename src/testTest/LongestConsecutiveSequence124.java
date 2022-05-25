package testTest;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence124 {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return 0;
        }
        int result = 1;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int l = num.length;
        for(int i = 0;i < l;i++){
            int n = num[i];
            if(map.keySet().contains(n)){
                continue;
            }
            if(!map.keySet().contains(n - 1) && !map.keySet().contains(n + 1)){
               map.put(n,1);
            }
            else{
                int left = 0;
                int right = 0;
                if(map.keySet().contains(n - 1)){
                     left = map.get(n - 1);
                }
                if(map.keySet().contains(n + 1)){
                     right = map.get(n + 1);
                }
                int sum = left + right + 1;
                map.put(n,sum);
                if(sum > result){
                    result = sum;
                }
                map.put(n - left, sum);
                map.put(n + right,sum);             
            }
            
        }

        return result;

    }
}
