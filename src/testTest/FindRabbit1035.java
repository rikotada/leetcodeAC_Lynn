package testTest;

import java.util.HashMap;
import java.util.Map;

public class FindRabbit1035 {
	public int numRabbits(int[] answers) {
        // write your code here
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Integer count = 0;
        for(int i = 0;i<answers.length;i++){
           if(!map.containsKey(answers[i]+1)) {
        	   map.put(answers[i]+1, 1);
        	   count = count + answers[i]+1;
           }
           else {
        	   int curr = map.get(answers[i]+1);
        	   map.replace(answers[i]+1, curr+1);
        	   if((curr % (answers[i]+1) == 0)) {
        		   count = count + answers[i]+1;
               }
           }
           
        }
      return count;
    }
}
