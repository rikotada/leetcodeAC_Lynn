package testTest;

public class FirstPositionOfTarget14 {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        if(target < nums[0] || target > nums[n-1]){
            return -1;
        }
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                right = mid;
            }
            if(nums[mid] > target){
               right = mid;
            }
            else if(nums[mid] < target){
               left = mid;
            }
        }
        if(nums[left] == target){
            return left;
        }
        else if(nums[right] == target){
            return right;
        }
        return -1;

    }

 
}