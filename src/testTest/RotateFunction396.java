package testTest;

public class RotateFunction396 {
    public int maxRotateFunction(int[] nums) {
        if(nums.length == 1){
           return 0;
        }
        int result = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        int fx = 0;
        for(int i = 0;i < n;i++){
           sum += nums[i];
           fx += i * nums[i];
        }
        result = fx;

        for(int i = 1;i < n;i++){
            fx = fx + sum - n * nums[n - i];
            result = Math.max(result,fx);
        }
        return result;


    }

  
}
