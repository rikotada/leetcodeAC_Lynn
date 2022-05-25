package testTest;

public class MedianOfKSortedArrays931{
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    public double findMedian(int[][] nums) {
        // write your code here
        if(nums == null || (nums.length == 1 & nums[0].length == 0)){
            return 0;
        }
        int n = 0;
        for(int[] arr:nums){
            if(arr == null || arr.length == 0){
               continue;
            }
           n += arr.length;
        }
        if(n % 2 != 0){
            return getKth(nums, n / 2 + 1) / 1.0;
        }
        long a = getKth(nums, n / 2);
        // System.out.println(a);
        long b = getKth(nums, n / 2 + 1);
        // System.out.println(b);
        return (a + b) / 2.0;


    }
    
    //k start from 1 but not 0
    public int getKth(int[][] nums,int k){
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left + 1 < right){
           int mid = (right - left) / 2 + left;
           int lessOrEqual = getLargerIn2D(nums, mid);
           //为了找到第一个 整体左移
           if(lessOrEqual >= k){
               right = mid;
           }
           else{
               left = mid;
           }          
        }
        // System.out.println("k: "+k);
        // System.out.println("left: "+left+" right: "+right);
        if(getLargerIn2D(nums, left) >= k){
            return left;
        }
        return right;
        
    }

    
    public int getLargerIn2D(int[][] nums,int target){
        int result = 0;
        for(int[] arr:nums){
           result += numsLessOrEqualThan(arr,target);
        }
        return result;
         
    }

    public int numsLessOrEqualThan(int[] num,int target){
        if(num.length == 0){
           return 0;
        }
        int left = 0;
        int right = num.length - 1;
        if(target >= num[right]){
           return num.length;
        }
        if(target < num[0]){
           return 0;
        }
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(target >= num[mid]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if(num[right] == target){
            return right + 1;
        }

        return left + 1;
    }


}
