package testTest;

import java.util.Stack;

public class MergeSortedArrayEasyVersion64 {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int leftA = 0;
        int leftB = 0;
        int sum = m+n;
        while(leftA < sum && m < sum){
           if(A[leftA] < B[leftB] && A[leftA] !=0){
              leftA++;
           }
           else if (A[leftA] >= B[leftB]){
               for(int i = m-1; i >= leftA;i--){
                  A[i+1] = A[i];
               }
               A[leftA] = B[leftB];
               m++;
               leftB++;
           }
           else if(A[leftA] == 0){
                A[leftA] = B[leftB];
                leftA++;
                leftB++;
                m++;
           }
        }
    }
}
