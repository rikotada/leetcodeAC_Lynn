package testTest;

public class LastPositionOfTarget458 {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0){
             return -1;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1; 
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(nums[mid] > target){
               right = mid;
            }
            if(nums[mid] <= target){
               left = mid;
            }
        }
        //check right end first
        if(nums[right] == target){
             return right;
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}