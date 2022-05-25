package testTest;

public class FindPeakElement75 {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        return binarySearch(A);

    }

    public int binarySearch(int[] nums){
       int start = 0,end = nums.length - 1;
       while(start + 1 < end){
           int mid = start + (end - start) / 2;
           int leftDirection = nums[start] - nums[start + 1];
           if(leftDirection * (nums[mid] - nums[mid - 1]) > 0){
                end = mid;
           }
           else if(leftDirection * (nums[mid] - nums[mid - 1]) < 0){
                start = mid;
           }
           if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
               return mid;
           }
       }
       return 0;
    }
}
