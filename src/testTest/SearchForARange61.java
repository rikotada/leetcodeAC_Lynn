package testTest;

public class SearchForARange61 {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = {-1,-1};
        if(A == null || A.length == 0 || A[0] > target || A[A.length - 1] < target){
             return result;
        }
        int startFromHere = binarySearch(A,target);
        if(startFromHere < 0){
             return result;
        }
        int start = startFromHere;
        int end = startFromHere;
        while(start-1 >= 0  && A[start-1] == target){
            start--;
        }
        while(end+1 < A.length  && A[end+1] == target){
            end++;
        }
        result[0] = start;
        result[1] = end;
        return result;
    }

    public int binarySearch (int[] A,int target){
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] >= target){
                 end = mid;
            }
            else{
                start = mid;
            }
        }
        if(A[start] == target){
            return start;
        }
        else if(A[end] == target){
            return end;
        }
        return -1;
    }
}