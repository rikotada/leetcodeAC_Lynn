package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	/**
	 * @param numbers: An array of Integer
	 * @param target: target = numbers[index1] + numbers[index2]
	 * @return: [index1, index2] (index1 < index2)
	 */
	public int[] twoSum(int[] numbers, int target) {
	    // write your code here
	    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	    Integer j = 0;
	    for(int i: numbers){
	        
	        if(map.get(target - i) != null){
	            int[] result = {map.get(target - i),j};
	            return result;
	        }
	        map.put(i,j);
	        j++;
	    }
	    return null;
	}
}
