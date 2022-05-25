package testTest;

public class TwoSumDifferenceEqualsToTarget610 {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int n = nums.length;
        int[] result = {-1,-1};
        if(n < 2){
            return result;
        }
        target = Math.abs(target);
        int j = 1;
        for(int i = 0;i < n;i++){
            for(j = Math.max(j,i+1);j < n;j++){
                if(nums[j] - nums[i] >= target){
                    break;
                }
            }
            if(nums[j] - nums[i] == target){
                result[0] = nums[i];
                result[1] = nums[j];
                return result;
            }
        }

        return result;
    }
}