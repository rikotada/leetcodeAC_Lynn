package testTest;

public class TwoSumIIInputArrayIsSorted608 {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] result = new int[2];
        if(nums == null || nums.length == 0){
            return result;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
           if(nums[left] + nums[right] > target){
               right--;
           }
           else if(nums[left] + nums[right] < target){
               left++;
           }
           else if(nums[left] + nums[right] == target){
              result[0] = left + 1;
              result[1] = right + 1;
              return result;
           }
        }
        return result;
    }
}
