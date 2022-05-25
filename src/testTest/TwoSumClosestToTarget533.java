package testTest;

import java.util.Arrays;

public class TwoSumClosestToTarget533 {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        Integer result = Integer.MAX_VALUE;
        if(nums == null || nums.length == 0){
             return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        quickSort(nums,0,nums.length - 1);
        while(left < right){
            int sum = nums[left] + nums[right];
            result = Math.min(result,Math.abs(sum - target));
            if(sum < target){                              
                left++;
            }
            else if(sum > target){
               right--;
            }
            else if(sum == target){
                return 0;
            }
        }
        return result;
    }

    public void quickSort(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[start + (end -start) / 2];
        while(left <= right){
            while(left <= right && nums[left] < pivot){
               left++;
            }
            while(left <= right && nums[right] > pivot){
               right--;
            }
            if(left <= right){
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
                right--;
            }
        }
        quickSort(nums,start,right);
        quickSort(nums,left,end);
    }
}
