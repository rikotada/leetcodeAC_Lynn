package testTest;

public class MedianOfTwoSortedArrays65 {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if((A == null || A.length == 0) && (B == null || B.length == 0)){
            return 0.0;
        }
        if(A == null || A.length == 0){
            if(B.length % 2 == 1){
                return  B[B.length / 2];
            }
            return 0.5 * (B[B.length / 2] + B[B.length / 2 - 1]);
        }
        if(B == null || B.length == 0){
            if(A.length % 2 == 1){
                return  A[A.length / 2];
            }
            return 0.5 * (A[A.length / 2] + A[A.length / 2 - 1]);
        }
        
        int lengthA = A.length;
        int lengthB = B.length;
        int total = (lengthA + lengthB + 1) / 2;
        int[] shorter = null;
        int[] longer = null;
        if(lengthA <= lengthB){
           shorter = A;
           longer = B;
        }
        else{
            shorter = B;
            longer = A;
        }
        int start = 0;
        int end = shorter.length;
        int target = -1;
        if(ifSplitCorrectly(shorter,longer,start,total) >= 0){
            target = start;
        }
        else if(ifSplitCorrectly(shorter,longer,end,total) >= 0){
            target = end;
        }
        else{
           while(start + 1 < end){
               int pivot  = start + (end - start) / 2;
               int now = ifSplitCorrectly(shorter,longer,pivot,total);
               if(now >= 0){
                  target = pivot;
                  break;
                }
                else{
                  int leftPivot = 0;
                  int rightPivot = shorter.length;
                  if(pivot != 0){
                      leftPivot = pivot - 1;
                  }
                  if(pivot != shorter.length){
                      rightPivot = pivot + 1;
                  }
                  int a = ifSplitCorrectly(shorter,longer,leftPivot,total);
                  int b = ifSplitCorrectly(shorter,longer,rightPivot,total);
                  if(a < now || b > now){
                      start = pivot;
                  }
                  else{
                      end = pivot;
                  }
                }
            }
        }
        if(target < 0){
           if(ifSplitCorrectly(shorter,longer,start,total) >= 0){
               target = start;
           }
           else{
               target = end;
           }
        }
        if((lengthA + lengthB) % 2 == 1){
            return maxLeftCal(shorter,longer,target,total);
        }
        return 0.5 *(maxLeftCal(shorter,longer,target,total) + minRightCal(shorter,longer,target,total));
    }
    
    public int ifSplitCorrectly(int[] A,int[] B,int pivotA,int total){
         int maxLeft = maxLeftCal(A,B,pivotA,total);
         int minRight = minRightCal(A,B,pivotA,total);
         return minRight - maxLeft;
    }

    public int maxLeftCal(int[] A,int[] B,int pivotA,int total){
        int pivotB = total - pivotA;
        int max = 0;
        if(pivotA == 0){
            max = B[pivotB-1];
        }
        else if(pivotB == 0){
            max = A[pivotA - 1];
        }
        else{
           max = Math.max(A[Math.max(0,pivotA-1)],B[Math.max(0,pivotB-1)]);
        }
        return max;
    }

    public int minRightCal(int[] A,int[] B,int pivotA,int total){
        int pivotB = total - pivotA;
        int min = 0;
        if(pivotA == A.length){
            min = B[pivotB];
        }
        else if(pivotB == B.length){
            min = A[pivotA];
        }
        else{
            min = Math.min(A[Math.min(A.length-1,pivotA)],B[Math.min(B.length-1,pivotB)]);
        }
        return min;
    }

}
