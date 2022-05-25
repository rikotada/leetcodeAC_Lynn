package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import testTest.Dequeue.ListNode;

public class TwoSumLessThan {
	public int twoSum5(int[] nums, int target) {
        // write your code here
        if(nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        for(int a:nums) {
        	list.add(a);
        }
        Integer length = nums.length - 1;
        Integer left = length;

        while((Integer)list.get(left-1) + (Integer)list.get(length) > target){
            left--;
        }
        Integer total = fact(length) / 2; 
        Integer sub = fact(length - left) / 2;
        return total -sub;
    }
    
    private Integer fact(Integer i){
        if(i == 1){
            return 1;
        }
        if(i == 0){
            return 0;
        }
        return fact(i-1)*i;
    }
    
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		TwoSumLessThan a = new TwoSumLessThan();
		a.twoSum5(nums,24);
	}
    
    
    
}
