package testTest;

public class KthLargestElementII606 {
    /**
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        quickSort(nums,0,length-1);
        return nums[length - k];
    }

    public void quickSort(int[] nums,int start,int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while(left <= right){
            while(left <= right  && nums[left] < pivot){
               left++;
            }
            while(left <= right && nums[right] > pivot){
               right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums,start,right);
        quickSort(nums,left,end);
    }
}
