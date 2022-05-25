package testTest;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithAtLeastKDistinctCharacters1375 {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: the number of substrings there are that contain at least k distinct characters
     */
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        int length = s.length();
        long result = 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < length){
           char c = s.charAt(right);
           map.put(c,map.getOrDefault(c,0)+1);
           while(map.size() >= k){
              char d = s.charAt(left);
              if(map.get(d) > 1){
                  map.put(d,map.get(d) - 1);
              }
              else{
                 map.remove(d);
              } 
              result = result + length - right;
              left++;
           }
           right++;
        }
        return result;
    }

}
