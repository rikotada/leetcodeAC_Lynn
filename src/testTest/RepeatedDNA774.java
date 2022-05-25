package testTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNA774 {
    /**
     * @param s: a string represent DNA sequences
     * @return: all the 10-letter-long sequences 
     */
    public List<String> findRepeatedDna(String s) {
        // write your code here
	   List<String> result = new ArrayList<>();
	   if(s == null || s.length() < 10){
            return result;
	   }
	   int left = 0;
	   int right = 10;
	   Map<String,Integer> map = new HashMap<>();
	   while(right <= s.length()){
            String sub = s.substring(left, right);
		  if(map.keySet().contains(sub) && map.get(sub) == 1){
                result.add(sub);
			 map.put(sub,map.get(sub) + 1);
		  }
		  else if(!map.keySet().contains(sub)){
               map.put(sub,1);
		  }
		  left++;
		  right++;
	   }
	   return result;
    }
}
