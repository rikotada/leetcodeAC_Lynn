package testTest;

public class FindKClosestElements460 {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        int[] result = new int[k];
        if(A == null || A.length == 0 || k == 0){
           return new int[0];
        }
        int a = binarySearch(A,target);
        result[0] = A[a];
        int i = 1;
        int left = a-1;
        int right = a+1;
        while(i < k){
            if(right >= A.length){
               result[i] = A[left];
               left--;
            }
            else if(left < 0){
               result[i] = A[right];
               right++;
            }
            else if(target - A[left] <= A[right] - target){
               result[i] = A[left];
               left--;
            }
            else if(target - A[left] > A[right] - target){
               result[i] = A[right];
               right++;
            }
            i++;
        }
        return result;
    }

    public int binarySearch(int[] nums,int target){
        int start = 0,end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(target - nums[start] <= nums[end] - target){
           return start;
        }
        return end;
    }
}
