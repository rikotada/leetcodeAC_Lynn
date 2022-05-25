package testTest;

public class SearchInRotatedSortedArray62 {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
           return -1;
        }
        int n = A.length;
        int left = 0;
        if(A[left] == target){
           return left;
        }
        int right = n - 1;
        if(A[right] == target){
           return right;
        }
        int endNum  = A[n-1];
        while(left  + 1 < right ){
           int mid = (left + right) / 2;
           if(target == A[mid]){
               return mid;
           }
           if((A[mid] - endNum) * (target - endNum) > 0){
              if(target > A[mid]){
                  left = mid;
              }
              else{
                  right = mid;
              }
           }
           else{
               if(target > A[mid]){
                  right = mid;
               }
               else{
                   left = mid;
               }
           }
           
        }
        return -1;
    }
}