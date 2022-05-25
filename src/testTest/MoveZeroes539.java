package testTest;

public class MoveZeroes539 {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int left = 0;
        int zero = 0;
        while(zero < nums.length){
           while(left < nums.length && nums[left] != 0){
              left++;
           }
           zero = left;
           while(zero < nums.length && nums[zero] == 0){
              zero++;
           }
           if(zero >= nums.length){
               break;
           }
           nums[left] = nums[zero];
           nums[zero] = 0;
           left++;
        }
    }
}
