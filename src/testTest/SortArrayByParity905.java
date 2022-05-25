package testTest;

public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] nums) {
       int len = nums.length;

       int odd = 0;
       int even = len - 1;
       while(odd < even){
           while(odd < len && nums[odd] % 2 == 0){
                odd++;
           }
           while(even > 0 && nums[even] % 2 == 1){
                even--;
           }
           if(even > 0 && odd < len && odd < even){
              int temp = nums[even];
              nums[even] = nums[odd];
              nums[odd] = temp;
           }
           odd++;
           even--;
       }

       return nums;
    }
}
