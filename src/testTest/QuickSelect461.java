package testTest;

public class QuickSelect461 {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        
        return quickSelect(nums,0,n-1,k-1);
    }

    public int quickSelect(int[] nums,int start,int end,int k){
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        while(left <= right){
            while(left <= right && nums[left] < pivot){
               left++;
            }
            while(left <= right && nums[right] > pivot){
               right--;
            }
            if(left <= right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
        if(k <= right && start <= right){
           return quickSelect(nums,start,right,k);
        }
        else if(k >= left && left <= end){
           return quickSelect(nums,left,end,k);
        }
        else{
            return nums[k]; 
        }
    }
}
