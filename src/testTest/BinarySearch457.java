package testTest;

public class BinarySearch457 {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int a = -1;
        int b = binarySearch(nums,target);
        if(nums[b] == target){
            return b;
        }
        return a;
    }
    public int binarySearch(int[] nums,int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
           int mid = start + (end - start) / 2;
           if(nums[mid] >= target){
               end = mid;
           }
           else{
               start = mid;
           }
        }
        return end;
    }
}
