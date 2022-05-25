package testTest;

public class FindMinimumInRotatedSortedArray159 {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null ||nums.length == 0){
            return -1;
        }
        int n = nums.length - 1;
        //没有旋转
        if(nums[n] > nums[0]){
           return nums[0];
        }
        return nums[binarySearch(nums)];
    }

    public int binarySearch(int[] nums){
       int start = 0,end = nums.length - 1;
       while(start + 1 < end){
           int mid = start + (end - start) /2 ;
           if(Math.abs(nums[mid] - nums[start]) >= Math.abs(nums[mid] - nums[end])){
                 end = mid;
           }
           else{
               start = mid;
           }
       }
       return end;
    }
}
