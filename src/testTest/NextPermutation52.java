package testTest;

import java.util.Arrays;

public class NextPermutation52 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1 ){
            return nums;
        }
        if(continueDecrease(nums)){
            Arrays.sort(nums);
            return nums;
        }
        int n = nums.length - 1;
        //如果最后两位数递增 把他们调个
        if(nums[n] > nums[n-1]){
            int temp = nums[n];
            nums[n] = nums[n-1];
            nums[n-1] = temp;
        }
        
        //如果最后两位不递增 就找到从后往前第一个出现递增的地方 
        //找到这个位置的值 在后续数列里找到比这个数达的最小值 调个
        //然后对后续数组进行从小到大排序
        //排序操作在这样一个 NP 问题中，消耗的时间几乎可以忽略
        else if(nums[n] <= nums[n-1]){
            int j = n;
            while(j >= 1 && nums[j] <= nums[j-1]){
                j--;
            }
            j = j-1;
            int nextFirst = findBigger(nums,j);
            System.out.println("-----"+nextFirst);
            int temp1 = nums[nextFirst];
            nums[nextFirst] = nums[j];
            nums[j] = temp1;
            //开闭区间 记得加一
            Arrays.sort(nums,j+1,n+1);
        }
        return nums;
    }
    
    public boolean continueDecrease(int[] nums){
        for(int i = 0; i+1 < nums.length; i++){
            if(nums[i] < nums[i+1]){
                return false;
            }
        }
        return true;
    }
    
    public int findBigger(int[] nums, int start){
        int min = Integer.MAX_VALUE;
        int min_pivot = start;
        int j = start+1;
        while(j < nums.length && nums[j] > nums[start]){
            if(nums[j] < min){
                min = nums[j];
                min_pivot = j;
            }
            j++;
        }
        return min_pivot;
    }
}


